class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        String sStr = new String(sChar);
        String tStr = new String(tChar);

        if(sStr.equals(tStr)) return true;
        return false;
    }
}
