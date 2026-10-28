class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;

        char[][] temp = new char[m][n];
        for(char[] row : temp){
            Arrays.fill(row, 'X');
        }
        

        for(int i = 0; i < n; i++){
            //top and bottom boundary traversal
            if(board[0][i] == 'O'){
                dfs(board, 0, i, temp);
            }

            if(board[m - 1][i] == 'O'){
                dfs(board, m-1, i, temp);
            }
            
        }

        for(int j = 0; j < m; j++){
            //left and right boundary traversal
            if(board[j][0] == 'O'){
                dfs(board, j, 0, temp);
            }

            if(board[j][n - 1] == 'O'){
                dfs(board, j, n-1, temp);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = temp[i][j];
            }
        }

    }

    private void dfs(char[][] board, int sr, int sc, char[][] temp){
        if(sr < 0 || sr >= board.length || sc < 0 || sc >= board[0].length || board[sr][sc] != 'O' || temp[sr][sc] == 'O'){
            return;
        }

        temp[sr][sc] = 'O';

        //up
        dfs(board, sr - 1, sc, temp);
        //down
        dfs(board, sr + 1, sc, temp);
        //left
        dfs(board, sr, sc - 1, temp);
        //right
        dfs(board, sr, sc + 1, temp);
    }
}