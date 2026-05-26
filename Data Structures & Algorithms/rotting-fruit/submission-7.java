class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] d : directions){
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(0 <= nr && nr < rows && 0 <= nc && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if(rotted) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}