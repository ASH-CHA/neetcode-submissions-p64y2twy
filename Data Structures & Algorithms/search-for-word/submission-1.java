class Solution {

    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(backtrack(i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index){
        if(index >= word.length()) return true;

        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '#';
        int[] rowOffSet = {0, 1, 0, -1};
        int[] colOffSet = {-1, 0, 1, 0};
        boolean ret = false;

        for(int i = 0; i < 4; i++){
            ret = backtrack(row + rowOffSet[i], col + colOffSet[i], word, index + 1);
            if(ret) break;
        }

        board[row][col] = word.charAt(index);
        return ret;
    }
}