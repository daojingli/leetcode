/**
 * Given a sorted array of integers, find the starting and ending position 
 * of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length ==  0) return res;
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] > target || nums[hi] < target) return res; //optimization
        //find the lower bound;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[lo] != target) return res;
        res[0] = lo;
        //find the upper bound;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2; // Make mid biased to the right
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        res[1] = hi;
        return res;
    }
}