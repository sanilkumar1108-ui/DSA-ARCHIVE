class Solution {
    static class Pair implements Comparable<Pair>{
        int row; 
        int col;
        int wt;
        public Pair(int r, int c, int w){
            this.row = r;
            this.col = c;
            this.wt = w;
        }

        @Override
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean vis[][] = new boolean[n][n];
        //direction
        int dr[] = {0,-1,0,1};
        int dc[] = {-1,0,1,0};

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int r = curr.row;
            int c = curr.col;
            int w = curr.wt;
            // skip outdated entries
            if(vis[r][c] == true){
                continue;
            }
            vis[r][c] = true;

            if(r == n -1 && c == n-1){
                return w;
            }

            for(int i = 0; i < 4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if(newR >= 0 && newC >= 0 && newR < n && newC < n && vis[newR][newC] != true){
                    int newWt = Math.max(curr.wt, grid[newR][newC]);
                    pq.add(new Pair(newR, newC, newWt));
                }
            }
        }
        return -1;
    }
}