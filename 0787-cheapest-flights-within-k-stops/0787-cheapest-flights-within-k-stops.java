class Solution {
    static class Edge{
        int d; 
        int wt;

        public Edge(int d, int w){
            this.d = d;
            this.wt = w;
        }
    }

    static class info{
        int v;
        int cost;
        int stops;
        public info(int v, int p, int s){
            this.v = v;
            this.cost = p;
            this.stops = s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            graph[u].add(new Edge(v, wt));
        }

        int dist[] = new int[n];
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        Queue<info> q = new LinkedList<>();
        q.add(new info(src,0,0));

        while(!q.isEmpty()){
            info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int v = e.d;
                int w = e.wt;

                if(curr.cost + w < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + w;
                    q.add(new info(v, dist[v], curr.stops + 1));
                }
            }

        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}