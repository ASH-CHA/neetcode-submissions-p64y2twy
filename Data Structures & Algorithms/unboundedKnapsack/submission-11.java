class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[] dp = new int[capacity + 1];

        for(int i = 0; i < n; i++){
            int currWeight = weight.get(i);
            int currProfit = profit.get(i);

            for(int w = 0; w <= capacity; w++){
                if(w >= currWeight){
                    dp[w] = Math.max(dp[w], currProfit + dp[w - currWeight]);
                }
            }
        }
        return dp[capacity];
    }
}