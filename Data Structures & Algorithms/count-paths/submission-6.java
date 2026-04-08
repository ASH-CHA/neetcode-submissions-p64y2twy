class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;

        for(int i = 1; i <= m - 1; i++){
            ans = ans * (i + n - 1) / i;
        }
        return (int)ans;
    }
}
