class Solution {
    public int findMin(int[] nums) {
        int ans = nums[0];
        if(nums.length == 0) return ans;
        int left = 0, right = nums.length - 1;

        while(left <= right){
            if(nums[left] <= nums[right]){
                ans = Math.min(ans, nums[left]);
            }

            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);

            if(nums[left] <= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }
}