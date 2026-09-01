class Solution {
    public String removeOuterParentheses(String s) {
        int count = -1;
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
                if(count >= 1){
                    sb.append(s.charAt(i));
                }
                continue;
            }
            count--;
            if(count > -1){
                    sb.append(s.charAt(i));
            }
            
            
        }
        
        return sb.toString();

    }
}