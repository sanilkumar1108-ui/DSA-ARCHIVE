class Solution {
    public int mySqrt(int x) {
        if(x == 1 || x == 0){
            return x;
        }

        int st = 0, end = x, mid = -1;
        while(st <= end){
            mid = st + (end - st)/2;
            if((long) mid * mid > (long) x){
                end = mid - 1;
            }else if(mid * mid == x){
                return mid;
            }else{
                st = mid + 1;
            }
        }
        return Math.round(end);
        
    }
}