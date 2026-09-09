class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num : nums) target += num;

        if(target % 2 != 0) return false;

        target /= 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}