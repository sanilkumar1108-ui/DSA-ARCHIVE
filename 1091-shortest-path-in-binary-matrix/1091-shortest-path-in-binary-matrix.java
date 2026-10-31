class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;
        int len = 1;

        //direction
        int dr[] = {-1,-1,-1,0,0,1,1,1};
        int dc[] = {-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i < size; i++){
                int curr[] = q.remove();
                int r = curr[0];
                int c = curr[1];

                if(r == n-1 && c == n-1){
                    return len;
                }

                for(int j = 0; j < 8; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(nr >= 0 && nc >= 0 && nc < n && nr < n && grid[nr][nc] == 0){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 1;
                    }
                }
            }
            len++;
        }
        return - 1;

    }
}