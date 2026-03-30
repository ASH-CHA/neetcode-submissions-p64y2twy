class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        long N = n;

        if(N < 0){
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        double currProduct = x;

        while(N > 0){
            if(N % 2 == 1) ans *= currProduct;

            currProduct *= currProduct;
            N /= 2;
        }
        return ans;
    }
}
