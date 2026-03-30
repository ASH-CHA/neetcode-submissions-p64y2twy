class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    private void backtrack(List<List<String>> ans, List<String> curr, String s, int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i + 1));
                backtrack(ans, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
