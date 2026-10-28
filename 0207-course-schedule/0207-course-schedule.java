class Solution {
    //it is a basic cycle detection problem in directed graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }

        boolean vis[] = new boolean[graph.length];
        boolean recPath[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(iscycle(graph, i, vis, recPath)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean iscycle(ArrayList<Integer> graph[], int curr, boolean[] vis, boolean recPath[]){
        vis[curr] = true;
        recPath[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            int neighbour = graph[curr].get(i);
            if(recPath[neighbour]){
                return true;
            }

            if(!vis[neighbour]){
                if(iscycle(graph, neighbour, vis, recPath)){
                    return true;
                }
            }
        }
        recPath[curr] = false;
        return false;
    }
}