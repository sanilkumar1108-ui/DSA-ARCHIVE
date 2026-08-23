class Solution {
    public String removeDuplicates(String s) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        int len = str.length();
        if (len > 0 && str.charAt(len -1) == s.charAt(i)) {
            str.deleteCharAt(len -1);
            continue;
        }
        str.append(s.charAt(i));
        len++;
    }
    return str.toString();
    }
}