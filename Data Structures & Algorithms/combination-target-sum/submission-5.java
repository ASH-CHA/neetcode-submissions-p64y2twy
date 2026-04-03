class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int target, int index){
        if(target < 0) return;
        else if(target == 0) ans.add(new ArrayList<>(curr));
        else{
            for(int i = index; i < nums.length; i++){
                curr.add(nums[i]);
                backtrack(ans, curr, nums, target - nums[i], i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
