/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 2) return "11";
        if (n == 1) return "1";
        String prev = countAndSay(n-1);
        char[] arr = prev.toCharArray();
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                res.append(count).append(arr[i-1]);
                count = 1;
            }
        }
        res.append(count).append(arr[arr.length-1]);
        return res.toString();
    }
}