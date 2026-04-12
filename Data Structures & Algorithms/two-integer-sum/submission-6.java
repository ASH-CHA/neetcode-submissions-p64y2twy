class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int otherNum = target - nums[i];

            if(seen.containsKey(otherNum)){
                return new int[]{seen.get(otherNum), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}
