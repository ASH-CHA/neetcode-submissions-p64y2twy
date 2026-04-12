class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, ans = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            if(seen.containsKey(c) && seen.get(c) >= left){
                left = seen.get(c) + 1;
            }
            ans = Math.max(ans, right - left + 1);
            seen.put(c, right);
        }
        return ans;
    }
}
