class Solution {

    private int rows;
    private int cols;

    public int countPaths(int[][] grid) {
        rows = grid.length; cols = grid[0].length;

        if(grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1){
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];

        return dfs(grid, visited, 0, 0);
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col){
        if(row == rows - 1 && col == cols - 1){
            return 1;
        }

        visited[row][col] = true;
        int paths = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(isValid(grid, visited, nr, nc)){
                paths += dfs(grid, visited, nr, nc);
            }
        }

        visited[row][col] = false;
        return paths;
    }

    private boolean isValid(int[][] grid, boolean[][] visited, int row, int col){
        return row >= 0 &&
               row < rows &&
               col >= 0 &&
               col < cols &&
               grid[row][col] == 0 &&
               !visited[row][col];
    }
}