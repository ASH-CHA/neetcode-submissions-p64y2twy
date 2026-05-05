class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(curr.contains(nums[i])) continue;

                curr.add(nums[i]);
                backtrack(ans, curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
