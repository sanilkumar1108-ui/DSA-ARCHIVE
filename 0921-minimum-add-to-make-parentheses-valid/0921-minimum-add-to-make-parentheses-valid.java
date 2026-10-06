class Solution {
    public int minAddToMakeValid(String s) {
        int closeneed = 0, openneed = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                closeneed++;
            }else{
                if(closeneed > 0){
                    closeneed--;
                }else{
                    openneed++;
                }
            }
        }
        return openneed + closeneed;
    }
}