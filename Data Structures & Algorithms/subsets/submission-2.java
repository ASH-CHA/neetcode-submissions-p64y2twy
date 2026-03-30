class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    private void backtrack(int index, List<Integer> curr, int[] nums, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
