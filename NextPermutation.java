/**
 * Implement next permutation, which rearranges numbers into the 
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as 
 * the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and 
 * its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int index = N - 2;
        while (index >= 0 && nums[index] >= nums[index+1])  index--;
        if (index < 0) {
            reverse(nums, 0, N - 1);
        } else {
            int j = N - 1;
            while (nums[j] <= nums[index]) j--; // find nums[j] the smallest number larger than nums[i] 
            swap(nums, index, j);
            reverse(nums, index + 1, N - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = 0; i <= (end -start) / 2; i++) 
            swap(nums, start + i, end - i);
    }
}