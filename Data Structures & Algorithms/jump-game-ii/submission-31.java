class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0, currMax = 0;

        for(int i = 0; i < nums.length - 1; i++){
            currMax = Math.max(currMax, nums[i] + i);

            if(i == currEnd){
                jumps++;
                currEnd = currMax;
            }
        }
        return jumps;
    }
}