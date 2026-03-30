class Solution {
    public int reverse(int x) {
        int ans = 0;
        boolean isNegative = x < 0;
        String strX = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(strX).reverse();

        try{
            ans = Integer.parseInt(sb.toString());
        } catch(NumberFormatException e){
            return 0;
        }

        return isNegative ? -ans : ans;
    }
}
