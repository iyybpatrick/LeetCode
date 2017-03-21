import java.util.*;
public class _40CombinationSumII {

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	List<List<Integer>> res = new LinkedList<>();
    if (candidates == null || candidates.length == 0) return res;
    Arrays.sort(candidates);
    ComSum(candidates, 0, target, res, new ArrayList<Integer>());
    return res;
    }
	private void ComSum(int[] candidates, int start, int target, List<List<Integer>> res, ArrayList<Integer> path) {
	// TODO Auto-generated method stub
	if (target == 0){
		res.add(new ArrayList<Integer>(path));
		return;
	}
	for (int i = start; i < candidates.length; i++){
		if (i != start && candidates[i] == candidates[i - 1]) continue;
		if (target >= candidates[i]){
			path.add(candidates[i]);
			ComSum(candidates, i + 1, target - candidates[i], res, path);
			path.remove(path.size() - 1);
		}else{
			return;
		}
	}//for
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_40CombinationSumII A =new _40CombinationSumII();
		int[]candidates = {10, 1, 1, 1, 2, 7, 6, 1, 5};
		List<List<Integer>> res = A.combinationSum2(candidates, 8);
		System.out.println(res);
	}

}

//question:
	//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	//
	//Each number in C may only be used once in the combination.
	//
	//Note:
	//All numbers (including target) will be positive integers.
	//The solution set must not contain duplicate combinations.
	//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
	//A solution set is: 
	//[
	//  [1, 7],
	//  [1, 2, 5],
	//  [2, 6],
	//  [1, 1, 6]
	//]
