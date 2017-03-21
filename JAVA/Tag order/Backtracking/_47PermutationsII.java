import java.util.*;
public class _47PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Calpermute(nums, res, new ArrayList<Integer>(), used);
        return res;
    }
	private void Calpermute(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, boolean[] used) {
		// TODO Auto-generated method stub
		if (list.size() == nums.length){
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++){
			if (used[i] == true) continue;
			if (i != 0 && nums[i] == nums[i - 1] && used[i-1] == false) continue;
			list.add(nums[i]);
			used[i] = true;
			Calpermute(nums, res, list, used);
			used[i] = false;
			list.remove(list.size() - 1);
		}//for
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_47PermutationsII  A= new _47PermutationsII ();
		int []nums=  {1,1,1,2};
		List<List<Integer>> res = A.permuteUnique(nums);
		System.out.println(res);
	}

}

//question:
	//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	//
	//For example,
	//[1,1,2] have the following unique permutations:
	//[
	//  [1,1,2],
	//  [1,2,1],
	//  [2,1,1]
	//]