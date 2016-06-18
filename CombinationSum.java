/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtracking(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void backtracking(int[] can, List<List<Integer>> res, List<Integer> list, int target, int start) {
        for (int i = start; i < can.length && can[i] <= target; i++) {
            list.add(can[i]);
            if (can[i] == target)  res.add(new ArrayList(list));
            else  backtracking(can, res, list, target - can[i], i);
            list.remove(list.size() - 1);
        }
    }
}