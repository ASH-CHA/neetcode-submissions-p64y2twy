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
        
        boolean ret = false;
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        for(int d = 0; d < 4; d++){
            ret = backtrack(row + rowDir[d], col + colDir[d], word, index + 1);
            if(ret) break;
        }

        board[row][col] = word.charAt(index);
        return ret;
    }
}
