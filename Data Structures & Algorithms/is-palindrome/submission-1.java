class Solution {
    public boolean isPalindrome(String s) {
        /*
        s = s.toLowerCase();
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "");

        int left = 0;
        int right = cleanStr.length() - 1;

        while(left < right){
            if(cleanStr.charAt(left) == cleanStr.charAt(right)){
                left++;
                right--;
            }
        }
        return false;*/

        // Brute Force
        StringBuilder sb = new StringBuilder();
        //s = s.toLowerCase();
        String cleanStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        for(int i = cleanStr.length() - 1; i >= 0; i--){
            sb.append(cleanStr.charAt(i));
        }

        return sb.toString().equals(cleanStr) ? true : false;
    }
}
