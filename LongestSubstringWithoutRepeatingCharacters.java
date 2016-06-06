/**
 * Given a string, find the length of the longest substring 
 * without repeating characters.
 *
 * Examples: 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int[] map = new int[128];
        for (int i = 0; i < 128; i++) map[i] = -1;

        int i = 0;
        int max = 0;
        for (int j = 0; j < arr.length; j++) {
            if (map[arr[j]] >= 0 ) {
                max = Math.max(j - i, max);
                i = Math.max(map[arr[j]] + 1, i);
            }
            map[arr[j]] = j;
        }
        return Math.max(arr.length - i, max);
    }
}