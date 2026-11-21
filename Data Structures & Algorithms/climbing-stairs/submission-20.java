class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;

        int curr = 1, prev = 1;
        for(int i = 0; i < n - 1; i++){
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
}