class Solution {
    public int minInsertions(String s) {
        int closeneed = 0; int openneed = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(closeneed %2 == 1){
                    openneed++;
                    closeneed--;
                }
                closeneed += 2;
            }else{
                if(closeneed <= 0){
                    openneed += 1;
                    closeneed++;
                }else{
                    closeneed--;
                }
            }
        }
        return closeneed + openneed;
    }
}