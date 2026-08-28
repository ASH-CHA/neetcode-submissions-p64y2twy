class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        int[] dp = new int[capacity + 1];
        dp[0] = 0;

        for(int w = 0; w <= capacity; w++){
            for(int i = 0; i < n; i++){
                if(w >= weight.get(i)){
                    dp[w] = Math.max(dp[w], dp[w - weight.get(i)] + profit.get(i));
                }
            }
        }
        return dp[capacity];
    }
}