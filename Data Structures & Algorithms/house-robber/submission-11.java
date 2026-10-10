class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        int max = nums[0];

        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = max;
        }
        return max;
    }
}