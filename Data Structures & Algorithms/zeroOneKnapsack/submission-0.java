class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[][] dp = new int[n + 1][capacity + 1];

        for(int i = 1; i <= n; i++){
            for(int c = 0; c <= capacity; c++){
                dp[i][c] = dp[i - 1][c];

                int currWeight = weight.get(i - 1);
                int currProfit = profit.get(i - 1);

                if(currWeight <= c){
                    dp[i][c] = Math.max(dp[i][c], currProfit + dp[i - 1][c - currWeight]);
                }
            }
        }
        return dp[n][capacity];
    }
}