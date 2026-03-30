class Solution {
    public boolean isPalindrome(String s) {
        // Brute Force
        /*StringBuilder sb = new StringBuilder();
        String cleanStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        for(int i = cleanStr.length() - 1; i >= 0; i--){
            sb.append(cleanStr.charAt(i));
        }

        return sb.toString().equals(cleanStr) ? true : false;*/

        // Two Pointers Solution O(1) space complexity
        int left = 0, right = s.length() - 1;

        while(left < right){
            while(left < right && !alphaNum(s.charAt(left))) left++;
            while(left < right && !alphaNum(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean alphaNum(char c){
        return(c >= 'a' && c <= 'z' ||
               c >= 'A' && c <= 'Z' ||
               c >= '0' && c <= '9');
    }
}
