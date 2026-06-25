class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights.length == 0 || heights[0].length == 0) return ans;

        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        for(int i = 0; i < rows; i++){
            dfs(i, 0, pacificReachable, heights);
            dfs(i, cols - 1, atlanticReachable, heights);
        }

        for(int j = 0; j < cols; j++){
            dfs(0, j, pacificReachable, heights);
            dfs(rows - 1, j, atlanticReachable, heights);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, boolean[][] reachable, int[][] heights){
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        reachable[row][col] = true;

        for(int[] dir : directions){
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length){
                continue;
            }

            if(reachable[nr][nc]) continue;
            if(heights[nr][nc] >= heights[row][col]) dfs(nr, nc, reachable, heights);
        }
    }
}