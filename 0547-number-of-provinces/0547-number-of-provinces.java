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

//actual question
        boolean vis[] = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                bfs(graph,i, vis);
                provinces++;
            }
        }
        return provinces;

    }

    public static void bfs(ArrayList<Edge> graph[], int city, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(city);
        vis[city] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]){
                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }

        }
    }
}