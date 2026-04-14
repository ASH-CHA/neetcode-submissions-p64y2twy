class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid){
        int newRow = grid.length;
        int newCol = grid[0].length;

        if(row < 0 || row >= newRow || col < 0 || col >= newCol || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int[] dir : directions){
            dfs(row + dir[0], col + dir[1], grid);
        }
    }
}
