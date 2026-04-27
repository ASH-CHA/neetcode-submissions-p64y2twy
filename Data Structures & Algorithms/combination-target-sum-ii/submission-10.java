class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int target, int index){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;

            curr.add(nums[i]);
            backtrack(ans, curr, nums, target - nums[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
