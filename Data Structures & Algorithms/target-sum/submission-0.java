class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for(int num : nums){
            total += num;
        }

        if(Math.abs(target) > total) return 0;

        int offSet = total;
        int size = 2 * offSet + 1;

        int[][] dp = new int[nums.length + 1][size];
        dp[0][offSet] = 1;

        for(int i = 1; i <= nums.length; i++){
            int num = nums[i - 1];

            for(int sum = -total; sum <= total; sum++){
                int prevWays = dp[i - 1][sum + offSet];

                if(prevWays != 0){
                    dp[i][sum + num + offSet] += prevWays;
                    dp[i][sum - num + offSet] += prevWays;
                }
            }
        }
        return dp[nums.length][target + offSet];
    }
}