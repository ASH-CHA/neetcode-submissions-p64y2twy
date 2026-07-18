class Solution {

    private int rows, cols;

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;

        rows = board.length; cols = board[0].length;

        for(int i = 0; i < rows; i++){
            dfs(i, 0, board);
            dfs(i, cols - 1, board);
        }

        for(int j = 0; j < cols; j++){
            dfs(0, j, board);
            dfs(rows - 1, j, board);
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

    private void dfs(int row, int col, char[][] board){
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O'){
            return;
        }

        board[row][col] = 'S';

        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
}