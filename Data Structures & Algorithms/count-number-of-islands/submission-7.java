class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] d : dir){
            int nr = row + d[0];
            int nc = col + d[1];

            dfs(grid, nr, nc);
        }
    }
}