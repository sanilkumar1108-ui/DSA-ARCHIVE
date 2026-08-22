class Solution {
    public boolean isPalindrome(String s) {
              StringBuilder str = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));
        System.out.println(str);
        
        int i = 0, j = str.length() - 1;
        if (str.length() == 0) {
            return true;
        }else{
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;  
    }
}