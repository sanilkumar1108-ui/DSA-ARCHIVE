class Solution {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //creating graph
        int n = isConnected.length;
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] != 0 && i != j){
                    graph[i].add(new Edge(i, j));
                }
            }
        }

        boolean vis[] = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(graph, i , vis);
                provinces++;
            }
        }
        return provinces;

    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
}