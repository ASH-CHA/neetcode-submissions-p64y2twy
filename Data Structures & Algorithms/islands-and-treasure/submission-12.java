class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(0 <= nr && nr < m && 0 <= nc && nc < n && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = grid[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}