import java.util.*;
public class _18_4Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len -1];
        for (int i = 0; i < len - 3; i++){
        	int min = nums[i];
        	if (i != 0 && min ==nums[i - 1]) continue; // remove duplicate
        	if (min + 3 * max < target) continue;  // it is too small
        	if (min * 4 > target) continue; // it is too large
        	if (min * 4 == target){
        		if (min == nums[i + 3]) res.add(Arrays.asList(min, min, min, min));
        		break;
        	}
        	CalThreeSum (nums, i + 1, len, target - min, res);
        }
        return res;
    }
	private void CalThreeSum(int[] nums, int lo, int hi, int target, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		for (int i = lo; i < hi - 2; i++){
			if (i != lo && nums[i] == nums[i -1]) continue;
			int sum = target - nums[i];
			int start = i + 1;
			int end = hi - 1;
			while (start < end){
				int curSum = nums[start] + nums[end];
				if (curSum == sum){
					res.add(Arrays.asList(nums[lo-1], nums[i], nums[start], nums[end]));
					while (start < end && nums[start] == nums[start + 1]) start++;
					while (start < end && nums[end] == nums[end -1]) end--;
				}
				if (curSum < sum){
					++start;
				}else{
					--end;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_18_4Sum A =new _18_4Sum();
		int []nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> res = A.fourSum(nums, 0);
		System.out.println(res);
	}

}

//question:
	//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
	//		Find all unique quadruplets in the array which gives the sum of target.
	//
	//Note: The solution set must not contain duplicate quadruplets.
	//
	//For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	//
	//A solution set is:
	//[
	//  [-1,  0, 0, 1],
	//  [-2, -1, 1, 2],
	//  [-2,  0, 0, 2]
	//]