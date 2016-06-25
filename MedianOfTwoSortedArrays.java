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

    //----------------solution II-----------------------------------------------

    public double findMedianSortedArraysII(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n ) / 2;
        int res = kth( k + 1, nums1, 0, m, nums2, 0, n);
        if ((m + n)  % 2 == 0) {
            int res2 = kth(k + 2, nums1, 0, m, nums2, 0, n);
            return (res + res2) / 2.0;
        }
        return res;
    }
    
    public int kth(int k, int[] a, int al, int ar, int[] b, int bl, int br) {
        int m = ar - al;
        int n = br - bl;
        if (m > n) return kth(k, b, bl, br, a, al, ar);
        System.out.println(m);
        System.out.println(n);
        if (m <= 0) return b[bl + k - 1];
        if (k == 1) return Math.min(a[al], b[bl]);
        
        int a_mid = Math.min(m, k / 2);
        int b_mid = k - a_mid;
        System.out.println("a_mid item: " + a[al + a_mid - 1]);
        System.out.println("b_mid item: " + b[bl + b_mid - 1]);
        if (a[al + a_mid - 1] > b[bl + b_mid - 1]) {
            return kth(k - b_mid, a, al, al + a_mid, b, bl + b_mid, br);
        } else if (a[al + a_mid - 1] < b[bl + b_mid - 1]) {
            return kth(k - a_mid, a, al + a_mid, ar, b, bl, bl + b_mid);
        } else return a[al + a_mid - 1];
    }

}