
public class _209MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int minLen = Integer.MAX_VALUE;
		int start = 0;
		int curSum = 0;
		int i = 0;
		while(i < nums.length){
			curSum += nums[i++];
			while (curSum >= s){
				minLen = Math.min(minLen, i - start);
				curSum -= nums[start++];
			}//while
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_209MinimumSizeSubarraySum A =new _209MinimumSizeSubarraySum();
		int []nums = {2,3,1,2,4,3};
		System.out.println(A.minSubArrayLen(7, nums));
	}

}

//question:
	//Given an array of n positive integers and a positive integer s, 
	//find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	//
	//For example, given the array [2,3,1,2,4,3] and s = 7,
	//the subarray [4,3] has the minimal length under the problem constraint.