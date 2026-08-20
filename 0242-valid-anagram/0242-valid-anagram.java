class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String sorted = new String(c);
        char[] d = t.toCharArray();
        Arrays.sort(d);
        String sorted1 = new String(d);
        return sorted.equals(sorted1);
    }
}