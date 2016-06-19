/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note:
 * 
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(), l2 = num2.length();
        int[] res = new int[l1 + l2];
        
        for (int i = 0; i < l1; i++) {
            int carry = 0;
            for (int j = 0; j < l2; j++) {
                int prod = (num1.charAt(l1 - 1 - i) -'0') * (num2.charAt(l2 - 1 - j) -'0') + res[i + j] + carry;
                res[i + j] = prod % 10;
                carry = prod / 10;
            }
            res[i + l2] += carry;
        }
        
        StringBuilder sb = new StringBuilder();
        if(res[res.length-1] != 0) sb.append(res[res.length-1]);
        for (int i = res.length - 2; i >= 0; i--) sb.append(res[i]);
        return sb.toString();
    }
}