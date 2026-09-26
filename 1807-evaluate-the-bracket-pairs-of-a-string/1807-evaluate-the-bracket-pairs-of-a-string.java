import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Populate hash map for O(1) key lookups
        Map<String, String> lookup = new HashMap<>();
        for (List<String> pair : knowledge) {
            lookup.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;

        // Step 2: Single pass traversal
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                inBracket = true;
                key.setLength(0); // Clear the key buffer
            } else if (ch == ')') {
                inBracket = false;
                String keyStr = key.toString();
                // Replace with mapped value, or '?' if key is not found
                result.append(lookup.getOrDefault(keyStr, "?"));
            } else {
                if (inBracket) {
                    key.append(ch);
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}