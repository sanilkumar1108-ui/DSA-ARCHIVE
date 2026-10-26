class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }
            if(grid[i][grid[0].length - 1] == 1){
                dfs(grid, i, grid[0].length - 1);
            }
        }

        for(int j = 0; j < grid[0].length; j++){
            if(grid[0][j] == 1){
                dfs(grid, 0, j);
            }
            if(grid[grid.length - 1][j] == 1){
                dfs(grid, grid.length - 1, j);
            }
        }
        //counting the rest of the 1

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][]grid, int sr, int sc){
        if(sr < 0 || sr >= grid.length){
            return;
        }
        if(sc < 0 || sc >= grid[0].length){
            return;
        }
        if(grid[sr][sc] == 0){
            return;
        }

        grid[sr][sc] = 0;

        //left
        dfs(grid, sr, sc - 1);
        //right
        dfs(grid, sr, sc + 1);
        
        // top
        dfs(grid, sr - 1, sc);
        //down
        dfs(grid, sr + 1, sc);
    }

}