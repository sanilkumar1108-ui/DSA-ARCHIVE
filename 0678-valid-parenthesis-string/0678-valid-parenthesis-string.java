class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;//min possible '('
        int leftMax = 0; // max possible ')'

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftMin++;
                leftMax++;
            }else if(ch == ')'){
                leftMin--;
                leftMax--;
            }else{
                leftMin--;//treat * as ')'
                leftMax++;//treat * as '('
            }

            if(leftMax < 0){
                return false;
            }

            if(leftMin < 0){
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}