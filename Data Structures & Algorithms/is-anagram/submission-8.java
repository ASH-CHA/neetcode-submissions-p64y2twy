class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] charCounts = new char[26];

        for(int i = 0; i < s.length(); i++){
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for(char count : charCounts){
            if(count != 0) return false;
        }
        return true;
    }
}
