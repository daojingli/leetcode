/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 *
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        List<Integer> list = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) 
            list.add(i);

        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) 
            factorial[i] = i * factorial[i - 1];

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            arr[i - 1] =  (char) (list.get(index) + '0');
            list.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(arr);
    }
}