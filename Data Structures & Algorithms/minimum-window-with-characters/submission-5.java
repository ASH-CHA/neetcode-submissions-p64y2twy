class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> needed = new HashMap<>();
        for(char c : t.toCharArray()){
            needed.put(c, needed.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int formed = 0;
        int required = needed.size();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if(needed.containsKey(c) && window.get(c).intValue() == needed.get(c).intValue()) formed++;

            while(formed == required){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                if(needed.containsKey(leftChar) && window.get(leftChar) < needed.get(leftChar)) formed--;
                left++;
             }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}