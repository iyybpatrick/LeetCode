import java.util.*;
public class _15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
        	if (i != 0 && nums[i] == nums[i-1]) continue;
        	int sum = -nums[i];
        	int start = i + 1;
        	int end = nums.length -1;
        	while (start < end){
        		int curSum = nums[start] + nums[end];
        		if (curSum == sum){
        			res.add(Arrays.asList(nums[i], nums[start], nums[end]));
        		}
        		if (curSum > sum){
        			while (start < end && nums[end - 1] == nums[end])  end--; end--;
        		}else{
        			while (start < end && nums[start] == nums[start + 1])  start++; start++;
        		}
        	}//while
        }//for
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_15_3Sum A =new _15_3Sum();
		int []nums = {-4,1,2,2,3};
		List<List<Integer>> res = A.threeSum(nums);
		System.out.println(res);
	}

}

//question:
	//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
	//
	//Note: The solution set must not contain duplicate triplets.
	//
	//For example, given array S = [-1, 0, 1, 2, -1, -4],
	//
	//A solution set is:
	//[
	//  [-1, 0, 1],
	//  [-1, -1, 2]
	//]