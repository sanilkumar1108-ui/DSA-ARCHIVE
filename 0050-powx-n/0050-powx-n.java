class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if( n == Integer.MIN_VALUE){
            x = x*x;
            n = n/2;
        }
        if(n < 0){
            x = 1/x;
            n = -1*n;
        }
        double halfPower = myPow(x, n/2);

        if(n %2 != 0){
            return x * halfPower * halfPower;
        }

        return halfPower*halfPower;
    }
}