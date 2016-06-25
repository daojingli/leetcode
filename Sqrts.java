/**
 * Implement int sqrt(int x)
 *
 * Compute and return the square root of x.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid)   hi = mid - 1;
            else if ((mid + 1) <= x / (mid + 1))  lo = mid + 1; 
            else return mid;
        }
        return lo;
    }
}