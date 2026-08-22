class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        
        StringBuilder rev =new StringBuilder(s).reverse();
        
       return s.equals(rev.toString()); 
    }
}