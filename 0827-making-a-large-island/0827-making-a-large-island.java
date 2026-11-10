class Solution {
    int n;
    int id[][];
    int area[];

    int dr[] = { -1, 0, 1, 0 };
    int dc[] = { 0, 1, 0, -1 };

    public int largestIsland(int[][] grid) {
        n = grid.length;
        id = new int[n][n];
        area = new int[n*n + 2];

        int island = 2;
        int maxArea = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && id[i][j] == 0){
                    int count = dfs(i, j, grid, island);

                    area[island] = count;
                    maxArea = Math.max(maxArea, area[island]);
                    island++;
                }
            }
        }

        // step 2
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> hs = new HashSet<>();

                    int newArea = 1;

                    for(int k = 0; k < 4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr >= 0 && nc >= 0 && nr < n && nc < n){
                            if(id[nr][nc] != 0 && hs.add(id[nr][nc])){
                                newArea += area[id[nr][nc]];
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        return maxArea;
    }

    //dfs
    private int dfs(int r, int c, int grid[][], int island) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] == 0 || id[r][c] != 0) {
            return 0;
        }
        id[r][c] = island;

        int count = 1;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            count += dfs(newR, newC, grid, island);
        }
        return count;
    }
}