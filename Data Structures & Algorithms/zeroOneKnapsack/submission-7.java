class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[] dp = new int[capacity + 1];

        for(int i = 0; i < weight.size(); i++){
            int currWeight = weight.get(i);
            int currProfit = profit.get(i);

            for(int c = capacity; c >= currWeight; c--){
                dp[c] = Math.max(dp[c], currProfit + dp[c - currWeight]);
            }
        }
        return dp[capacity];
    }
}