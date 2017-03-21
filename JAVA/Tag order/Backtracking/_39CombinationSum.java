import java.util.*;
public class _39CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
			if (target >= candidates[i]){
				path.add(candidates[i]);
				ComSum(candidates, i, target - candidates[i], res, path);
				path.remove(path.size() - 1);
			}else{
				return;
			}
		}//for
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_39CombinationSum A =new _39CombinationSum();
		int []candidates = {2,3,6,7};
		List<List<Integer>> res = A.combinationSum(candidates, 7);
		System.out.println(res);
	}

}

//question:
	//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	//
	//The same repeated number may be chosen from C unlimited number of times.
	//
	//Note:
	//All numbers (including target) will be positive integers.
	//The solution set must not contain duplicate combinations.
	//For example, given candidate set [2, 3, 6, 7] and target 7, 
	//A solution set is: 
	//[
	//  [7],
	//  [2, 2, 3]
	//]