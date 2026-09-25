import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        this.index = 0;
        Set<String> resultSet = parse(expression);
        
        // Convert to list and sort lexicographically
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parse(String expr) {
        Set<String> totalUnion = new HashSet<>();
        Set<String> currProduct = new HashSet<>();
        currProduct.add(""); // Neutral element for concatenation

        while (index < expr.length() && expr.charAt(index) != '}') {
            char c = expr.charAt(index);

            if (c == ',') {
                // Comma acts like addition: finalize current term into total union
                totalUnion.addAll(currProduct);
                currProduct = new HashSet<>();
                currProduct.add("");
                index++;
            } else if (c == '{') {
                // Enter nested expression
                index++; // Skip '{'
                Set<String> subResult = parse(expr);
                index++; // Skip '}'
                currProduct = cartesianProduct(currProduct, subResult);
            } else {
                // Single letter: form a singleton set and multiply
                Set<String> singleLetter = Collections.singleton(String.valueOf(c));
                currProduct = cartesianProduct(currProduct, singleLetter);
                index++;
            }
        }

        totalUnion.addAll(currProduct);
        return totalUnion;
    }

    // Computes the Cartesian product of two sets: {a, b} x {c, d} = {ac, ad, bc, bd}
    private Set<String> cartesianProduct(Set<String> setA, Set<String> setB) {
        Set<String> product = new HashSet<>();
        for (String a : setA) {
            for (String b : setB) {
                product.add(a + b);
            }
        }
        return product;
    }
}