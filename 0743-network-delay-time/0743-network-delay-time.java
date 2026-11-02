class Solution {
    static class Edge{
        int dest;
        int wt;
        public Edge(int d, int w){
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        int N = n;
        
        ArrayList<Edge> graph[] = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int t[] : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            graph[u].add(new Edge(v,w));
        }

        int dist[] = new int[N + 1];
        for(int i= 0; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            int u = curr.n;
            int d = curr.path;

            if(d > dist[u]) continue;

            for(int i = 0; i < graph[curr.n].size(); i++){
                Edge e = graph[curr.n].get(i);
                int v = e.dest;
                int w = e.wt;

                if(dist[v] > d + w){
                    dist[v] = d + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        int ans = 0;
        for(int i = 1; i < dist.length; i++){
            ans = Math.max(ans, dist[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}