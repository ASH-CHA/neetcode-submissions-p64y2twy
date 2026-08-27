class Solution {
    public int shortestPath(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;

        if(grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return -1;
        if(rows == 1 && cols == 1) return 0;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int paths = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            paths++;
            
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] d : dir){
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr < 0 || nr >= rows || nc < 0 || nc >= cols){
                        continue;
                    }
                    if(visited[nr][nc] || grid[nr][nc] == 1){
                        continue;
                    }
                    if(nr == rows - 1 && nc == cols - 1){
                        return paths;
                    }

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}