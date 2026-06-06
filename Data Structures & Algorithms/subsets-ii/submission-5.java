class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int index){
        ans.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i - 1] == nums[i]) continue;

            curr.add(nums[i]);
            backtrack(ans, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}