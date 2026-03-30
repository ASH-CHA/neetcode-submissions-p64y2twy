class Solution {
    public boolean isPalindrome(String s) {
        /*int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }

            if(left == s.length() / 2 || right == s.length() / 2){
                return true;
            }
        }
        return false;*/

        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "");

        for(int i = cleanStr.length() - 1; i >= 0; i--){
            sb.append(cleanStr.charAt(i));
        }

        return sb.toString().equals(cleanStr) ? true : false;
    }
}
