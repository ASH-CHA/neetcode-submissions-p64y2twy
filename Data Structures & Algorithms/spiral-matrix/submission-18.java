class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int x = 0, y = 0;
        int dx = 1, dy = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                ans.add(matrix[y][x]);
                matrix[y][x] = -101;

                if(!(x + dx >= 0 && x + dx < cols && y + dy >= 0 && y + dy < rows) || matrix[y + dy][x + dx] == -101){
                    int temp = dx;
                    dx = -dy;
                    dy = temp;
                }

                x += dx;
                y += dy;
            }
        }
        return ans;
    }
}