class Solution {

    private String[] digitsToLetters = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        backtrack(ans, digits, "", 0);
        return ans;
    }

    private void backtrack(List<String> ans, String digits, String curr, int index){
        if(index == digits.length()){
            ans.add(curr);
            return;
        }

        String letters = digitsToLetters[digits.charAt(index) - '0'];
        for(char letter : letters.toCharArray()){
            backtrack(ans, digits, curr + letter, index + 1);
        }
    }
}
