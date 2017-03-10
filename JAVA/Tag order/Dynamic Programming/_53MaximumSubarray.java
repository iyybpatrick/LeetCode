
public class _53MaximumSubarray {

	public int maxSubArray(int[] nums) {
		if (nums == null) return 0;
		int len = nums.length;
		int []calculate = new int[len];
		calculate[0] = nums[0];
		int max = calculate[0];
		for (int i = 1; i < len; i++){
			calculate[i] = nums[i] + (calculate[i-1] > 0 ? calculate[i-1] : 0);
			max = Math.max(max, calculate[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_53MaximumSubarray A= new _53MaximumSubarray();
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(A.maxSubArray(nums));
	}

}

//question:
	//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	//
	//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	//the contiguous subarray [4,-1,2,1] has the largest sum = 6.
