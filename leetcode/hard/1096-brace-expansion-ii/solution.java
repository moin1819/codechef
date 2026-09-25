import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        this.index = 0;
        Set<String> resultSet = parseExpression(expression);
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parseExpression(String expr) {
        // currentUnion accumulates terms separated by commas (A , B , C -> A U B U C)
        Set<String> currentUnion = new HashSet<>();
        
        // currentConcat tracks products of adjacent factors (A B C -> A * B * C)
        Set<String> currentConcat = new HashSet<>();
        currentConcat.add("");

        while (index < expr.length()) {
            char c = expr.charAt(index);

            if (c == '}') {
                break; // Handled by outer recursive call
            } else if (c == ',') {
                // Comma finishes the current concatenated term and moves to the next union branch
                currentUnion.addAll(currentConcat);
                currentConcat = new HashSet<>();
                currentConcat.add("");
                index++;
            } else if (c == '{') {
                index++; // Skip '{'
                Set<String> innerResult = parseExpression(expr);
                index++; // Skip '}'
                
                // Multiply inner result with current concatenated term
                currentConcat = multiply(currentConcat, innerResult);
            } else {
                // Regular character: append to current concatenated term
                Set<String> charSet = new HashSet<>();
                charSet.add(String.valueOf(c));
                currentConcat = multiply(currentConcat, charSet);
                index++;
            }
        }

        currentUnion.addAll(currentConcat);
        return currentUnion;
    }

    private Set<String> multiply(Set<String> set1, Set<String> set2) {
        Set<String> res = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }
}