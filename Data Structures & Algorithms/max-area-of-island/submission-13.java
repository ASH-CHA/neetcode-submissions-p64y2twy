class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid){
        int area = 1;

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        area += dfs(row + 1, col, grid);
        area += dfs(row - 1, col, grid);
        area += dfs(row, col + 1, grid);
        area += dfs(row, col - 1, grid);

        return area;
    }
}