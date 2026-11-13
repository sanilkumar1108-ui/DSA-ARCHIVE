class Solution {
    class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            int s = prerequisites[i][1];
            int d = prerequisites[i][0];
            graph[s].add(new Edge(s,d));
        }

        boolean vis[] = new boolean[n];
        boolean rec[] = new boolean[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(topSort(graph, i, vis, s, rec)){
                    return new int[0];
                };
            }
        }

        int res[] = new int[n];
        int a = 0;
        while(!s.isEmpty()){
            res[a] = s.pop();
            a++;
        }
        return res;
    }

    public boolean topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge neighbour = graph[curr].get(i);
            if(rec[neighbour.dest]){
                return true;
            }
            if(!vis[neighbour.dest] && topSort(graph, neighbour.dest, vis, s, rec)){
                return true;
            }
        }
        rec[curr] = false;
        s.push(curr);
        return false;
    }
}