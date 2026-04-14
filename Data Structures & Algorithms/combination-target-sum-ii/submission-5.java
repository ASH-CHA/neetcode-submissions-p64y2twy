class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int target, int index){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;

            curr.add(candidates[i]);
            backtrack(ans, curr, candidates, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
