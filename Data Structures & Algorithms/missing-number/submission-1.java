class Solution {
    public int missingNumber(int[] nums) {
        int xOr = 0;

        for(int i = 0; i <= nums.length; i++){
            xOr ^= i;
        }

        for(int i = 0; i < nums.length; i++){
            xOr ^= nums[i];
        }

        return xOr;
    }
}
