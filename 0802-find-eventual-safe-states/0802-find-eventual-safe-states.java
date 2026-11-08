class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> reverse[] = new ArrayList[graph.length];
        for(int i = 0; i < graph.length; i++){
            reverse[i] = new ArrayList<>(); 
        }

        int indegree[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                int u = i;
                int v = graph[i][j];

                reverse[v].add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNode = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            safeNode.add(curr);

            for(int i = 0; i < reverse[curr].size(); i++){
                int neighbour = reverse[curr].get(i);
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                } 
            }
        }
        
        Collections.sort(safeNode);
        return safeNode;
    }
}