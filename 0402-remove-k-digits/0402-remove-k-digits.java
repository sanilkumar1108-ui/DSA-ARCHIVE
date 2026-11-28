class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();

        s.push(num.charAt(0));

        for(int i = 1; i < num.length(); i++){
            char ch = num.charAt(i);
            while(!s.isEmpty() && k > 0 && ch < s.peek()){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        while(k > 0){
            s.pop();
            k--;
        }
        if(s.isEmpty()) return "0";
        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        ans.reverse();

        int i = 0;
        while(i < ans.length() - 1 && ans.charAt(i) == '0'){
            i++;
        }

        return ans.substring(i);
    }
}