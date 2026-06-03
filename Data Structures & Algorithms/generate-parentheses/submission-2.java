class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, n, 0, 0, "");
        return ans;
    }

    private void backtrack(List<String> ans, int n, int left, int right, String s){
        if(s.length() == n * 2){
            ans.add(s);
            return;
        }

        if(left < n) backtrack(ans, n, left + 1, right, s + '(');
        if(right < left) backtrack(ans, n, left, right + 1, s + ')');
    }
}