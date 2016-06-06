/*
* Given an array of integers, return indices of the two numbers such that 
* they add up to a specific target.
*
* You may assume that each input would have exactly one solution
* 
* Example:
*
* Given nums = [2, 7, 11, 15], target = 9,
*
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
*
*/
import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        for (int i = 0; i < N; i++) {
            Integer position = hm.get(nums[i]);
            if (position == null) 
                hm.put(target - nums[i] , i);
            else {
                return new int[] { position, i};
            }
        }
        throw new IllegalArgumentException();
    }
}