import java.util.*;
public class _90SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		DFS(nums, res, new ArrayList<Integer>(), 0);
		return res;
	    }
	private void DFS(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int start) {
		// TODO Auto-generated method stub
		res.add(new ArrayList<>(list));
		for (int i = start; i < nums.length; i++){
			if (i != start && nums[i] == nums[i - 1]) continue;
			list.add(nums[i]);
			DFS(nums, res, list, i + 1);
			list.remove(list.size() - 1);
		}//for
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_90SubsetsII A =new _90SubsetsII();
		int []nums=  {1,2,2};
		List<List<Integer>> res = A.subsetsWithDup(nums);
		System.out.println(res);
	}

}

//question:
	//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
	//
	//Note: The solution set must not contain duplicate subsets.
	//
	//For example,
	//If nums = [1,2,2], a solution is:
	//
	//[
	//  [2],
	//  [1],
	//  [1,2,2],
	//  [2,2],
	//  [1,2],
	//  []
	//]