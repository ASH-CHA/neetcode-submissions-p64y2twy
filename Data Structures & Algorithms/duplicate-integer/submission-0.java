class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];

            if(seen.containsKey(val)){
                return true;
            }
            seen.put(val, i);
        }
        return false;
    }
}