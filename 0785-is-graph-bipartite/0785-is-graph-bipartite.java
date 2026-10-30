class Solution {
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length]; // -1: no color, 0: blue, 1: gray.
        for (int i = 0; i < graph.length; i++) {
            col[i] = -1;//No color;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].length; j++) {
                        int neighbour = graph[curr][j];
                        if (col[neighbour] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[neighbour] = nextCol;
                            q.add(neighbour);
                        }

                        if (col[neighbour] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}