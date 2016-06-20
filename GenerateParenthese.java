/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is: 
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 */

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, int open, int close) {
        if (close == 0) {
            res.add(sb.toString());
            return;
        }
        
        if (open > 0) {
            sb.append("(");
            backtrack(res, sb, open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close > open) {
            sb.append(")");
            backtrack(res, sb, open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}