class Solution {
    static class Edge{
        int dest;
        int wt;
        public Edge(int d, int w){
            this.dest = d;
            this.wt = w;
        }
    }
    static class info implements Comparable<info>{
        int a;
        int cost;
        public info(int a, int c){
            this.a = a;
            this.cost = c;
        }

        @Override
        public int compareTo(info i2){
            return this.cost - i2.cost;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        int minCount = Integer.MAX_VALUE;
        int count = 0;
        int answer = 0;

        for(int src = 0; src < n; src++){
            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<info> pq = new PriorityQueue<>();

            dist[src] = 0;
            pq.add(new info(src, 0));
            while(!pq.isEmpty()){
                info curr = pq.remove();

                for(int j = 0; j < graph[curr.a].size(); j++){
                    Edge e = graph[curr.a].get(j);
                    int v = e.dest;
                    int w = e.wt;

                    if(curr.cost + w < dist[v]){
                        dist[v] = curr.cost + w;
                        pq.add(new info(v, dist[v]));
                    }
                }
            }

            count = 0;
            for(int k = 0; k < n; k++){
                if(k != src && dist[k] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minCount){
                minCount = count;
                answer = src;
            }

        }
        return answer;
    }
}