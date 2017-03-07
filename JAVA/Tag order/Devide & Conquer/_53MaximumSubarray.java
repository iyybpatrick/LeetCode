
public class _53MaximumSubarray {

	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int dp[] = new int [len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i=1; i < len; i++){
        	dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_53MaximumSubarray A = new _53MaximumSubarray();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println( A.maxSubArray(nums));
	}

}

//question:
	//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	//
	//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	//the contiguous subarray [4,-1,2,1] has the largest sum = 6.
