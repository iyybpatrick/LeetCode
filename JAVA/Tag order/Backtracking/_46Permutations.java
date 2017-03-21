import java.util.*;
public class _46Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new LinkedList<>();
        CalPermute(nums, res, list);
        return res; 
    }
	private void CalPermute(int[] nums, List<List<Integer>> res, List<Integer> list) {
		// TODO Auto-generated method stub
		if (list.size() == nums.length){
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++){
			if (!list.contains(nums[i])){
				list.add(nums[i]);
				CalPermute(nums, res, list);
				list.remove(list.size() - 1);
			}
		}//for
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_46Permutations A =new _46Permutations();
		int []nums = {1,2,3};
		List<List<Integer>> res = A.permute(nums);
		System.out.println(res);
	}

}

//question:
	//Given a collection of distinct numbers, return all possible permutations.
	//
	//For example,
	//[1,2,3] have the following permutations:
	//[
	//  [1,2,3],
	//  [1,3,2],
	//  [2,1,3],
	//  [2,3,1],
	//  [3,1,2],
	//  [3,2,1]
	//]