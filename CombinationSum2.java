/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void backtracking(int[] can, List<List<Integer>> res, List<Integer> list, int target, int start) {
        for (int i = start; i < can.length && can[i] <= target; i++) {
            if (i > start && can[i] == can[i - 1]) continue;
            list.add(can[i]);
            if (can[i] == target)  res.add(new ArrayList(list));
            else  backtracking(can, res, list, target - can[i], i+1);
            list.remove(list.size() - 1);
        }
    }
}