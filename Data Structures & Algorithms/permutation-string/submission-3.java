class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(s1Map.equals(s2Map)) return true;

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++){
            char charRight = s2.charAt(right);
            s2Map.put(charRight, s2Map.getOrDefault(charRight, 0) + 1);

            char charLeft = s2.charAt(left);
            s2Map.put(charLeft, s2Map.get(charLeft) - 1);

            if(s2Map.get(charLeft) == 0){
                s2Map.remove(charLeft);
            }
            left++;

            if(s1Map.equals(s2Map)) return true;
        }
        return false;
    }
}