class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i < n; i++){
            count++;

            n = n & (n - 1);
        }
        return count;
    }
}
