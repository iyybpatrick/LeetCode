import java.util.*;
public class _491IncreasingSubsequences {

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
        if (nums == null) return res;
 
        for (int i = 2; i <= nums.length; i++){
        	DFS(nums, 0, i, cur, res);
        }//for
        return res;
    }
	private void DFS(int[] nums, int start, int count, List<Integer> cur, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if (count == 0){
			res .add(new ArrayList<Integer>(cur));
			return;
		}//if
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = start; i < nums.length; i++){
			if (map.containsKey(nums[i])) continue;
			if (start != 0 && nums[i] < nums[start - 1]) continue;
			map.put(nums[i], 1);
			cur.add(nums[i]);
			DFS(nums, i + 1, count - 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_491IncreasingSubsequences A = new _491IncreasingSubsequences();
		int []nums = {1,1,2,1,1,3,1,1};
		List<List<Integer>> res = A.findSubsequences(nums);
		System.out.println(res);
	}

}

//question:
	//Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
	//
	//Example:
	//Input: [4, 6, 7, 7]
	//Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
	//Note:
	//The length of the given array will not exceed 15.
	//The range of integer in the given array is [-100,100].
	//The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
