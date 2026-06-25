class Solution {

    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;

        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(i, j, dp, matrix));
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] dp, int[][] matrix){
        if(dp[i][j] != 0) return dp[i][j];

        for(int[] d : dir){
            int nextX = i + d[0];
            int nextY = j + d[1];

            if(0 <= nextX && nextX < m && 0 <= nextY && nextY < n && matrix[nextX][nextY] > matrix[i][j]){
                dp[i][j] = Math.max(dp[i][j], dfs(nextX, nextY, dp, matrix));
            }
        }
        return ++dp[i][j];
    }
}