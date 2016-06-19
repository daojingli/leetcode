/**
* Given a collection of distinct numbers, return all possible permutations.
* 
* For example,
* [1, 2, 3] have the following permutations:
* [
*  [1,2,3],
*  [1,3,2],
*  [2,1,3],
*  [2,3,1],
*  [3,1,2],
*  [3,2,1]
* ]
*/
import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int[] set = new int[nums.length];
		Arrays.fill(set, 0);
		backtrack(res, new ArrayList<Integer>(nums.length), set, nums);
		return res;
	}

	private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] set, int[] nums) {
		if (list.size() == nums.length) {
		    res.add(new ArrayList(list));
		} else {
			for (int i = 0; i < nums.length; i++) {
			    if (set[i] == 0) {
			        set[i]++;
			        list.add(nums[i]);
			    	backtrack(res, list, set, nums);
			    	list.remove(list.size() -1);
			    	set[i]--;
			    } 
			}
		}
	}
}
