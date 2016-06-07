/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = kth((nums1.length + nums2.length -1) / 2, nums1, nums2);
        int b = kth((nums1.length + nums2.length) / 2, nums1, nums2);
        return (a + b) / 2.0;
    }
    
    private static int kth(int k, int[] a1, int[] a2) {
        if (a1.length == 0) return a2[k];
        if (a2.length == 0) return a1[k];

        int lo = 0;
        int hi = a1.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int pos = Arrays.binarySearch(a2, a1[mid]);
            int rank_l, rank_h;
            if (pos >= 0) {
                rank_l = pos + mid;
                rank_h = rank_l + 1;
            } else {
                rank_l = -1 * (pos + 1) + mid;
                rank_h = rank_l;
            }
            if (rank_h < k)  lo = mid + 1;
            else if (rank_l > k)  hi = mid -1;
            else return a1[mid];
        }
        
        return kth(k, a2, a1);
    }
}