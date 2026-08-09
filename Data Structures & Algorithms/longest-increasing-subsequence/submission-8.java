class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    ans[i] = Math.max(ans[i], 1 + ans[j]);
                    max = Math.max(max, ans[i]);
                }
            }
        }
        return max;
    }
}