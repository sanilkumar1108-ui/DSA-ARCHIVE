class Solution {
    public int reverseDegree(String s) {
        // if(s.length() == 0){
        //     return 0;
        // }
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int num = (i+1)*(26 - (s.charAt(i) - 'a'));
            sum += num;
        }
        return sum;
    }
}