class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0, count = 0;
        String beautiful = "";

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            }

            while (count == k) {
                String sub = s.substring(i, j + 1);

                if (beautiful.isEmpty() 
                    || sub.length() < beautiful.length() 
                    || (sub.length() == beautiful.length() && sub.compareTo(beautiful) < 0)) {
                    beautiful = sub;
                }

                if (s.charAt(i) == '1') {
                    count--;
                }
                i++;
            }
        }

        return beautiful;
    }
}