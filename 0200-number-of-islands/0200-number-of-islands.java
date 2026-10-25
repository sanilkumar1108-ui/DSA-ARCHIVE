class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    helper(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][]grid, boolean vis[][], int sr, int sc){
        if(sr < 0 || sr >= grid.length){
            return;
        }

        if(sc < 0 || sc >= grid[0].length){
            return;
        }
        if(vis[sr][sc] || grid[sr][sc] == '0'){
            return;
        }

        vis[sr][sc] = true;
        //left
        helper(grid, vis, sr, sc - 1);
        //right
        helper(grid, vis, sr, sc + 1);
        
        // top
        helper(grid, vis, sr - 1, sc);
        //down
        helper(grid, vis, sr + 1, sc);
    }
}