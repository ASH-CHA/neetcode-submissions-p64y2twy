class Solution {

    private int rows, cols;

    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;

        rows = board.length;
        cols = board[0].length;

        for(int i = 0; i < rows; i++){
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for(int j = 0; j < cols; j++){
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O'){
            return ;
        }

        board[i][j] = 'S';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}