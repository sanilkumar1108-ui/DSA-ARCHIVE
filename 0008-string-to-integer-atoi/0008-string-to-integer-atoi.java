class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        int i = 0;
        s = s.trim();
        if(s.isEmpty()) return 0;
            if(s.charAt(0) == '-'){
                sign = -1;
                i++;
            }
            if(s.charAt(0) == '+'){
                i++;
            }
        while(i < s.length()){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                if(ans > (Integer.MAX_VALUE - (s.charAt(i) - '0'))/10){
                    return (sign ==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans*10 + (s.charAt(i) - '0');
                i++;
            }
            else{
                return ans*sign;
            }
        }
        return ans*sign;
    }
}