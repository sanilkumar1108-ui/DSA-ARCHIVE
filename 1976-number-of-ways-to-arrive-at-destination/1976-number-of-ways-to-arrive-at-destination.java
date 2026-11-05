class Solution {
    static final int MOD = 1000000007;
    static class Edge{
        int dest;
        int wt;
        public Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int a;
        long cost;
        public Pair(int a, long p){
            this.a = a;
            this. cost = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return Long.compare(this.cost, p2.cost);
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long ways[] = new long[n];
        Arrays.fill(ways,0);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        dist[0] = 0;

        ways[0] = 1;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(curr.cost > dist[curr.a]){
                continue;
            }

            for(int i = 0; i < graph[curr.a].size(); i++){
                Edge e = graph[curr.a].get(i);
                int v = e.dest;
                int d = e.wt;

                if(curr.cost + d < dist[v]){
                    dist[v] = curr.cost + d;
                    pq.add(new Pair(v, dist[v]));
                    ways[v] = ways[curr.a];
                }else if(curr.cost + d == dist[v]){
                    ways[v] = (ways[curr.a] + ways[v]) % MOD;
                }
            }
        }
        return (int)ways[n - 1] % MOD;
    }
}