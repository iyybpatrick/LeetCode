
public class _209MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
         if (nums == null || nums.length == 0){
        	 return 0;
         }
         int fast = 0, slow = 0, sum = 0, min_len = Integer.MAX_VALUE;
         while (fast <= nums.length-1){
        	 sum += nums[fast++];
        	 while (sum >= s){
        		 min_len = Math.min(min_len, fast-slow);
        		 sum -= nums[slow++];
        	 }//while
         }//while
         return min_len == Integer.MAX_VALUE ? 0 :min_len;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 _209MinimumSizeSubarraySum A=new  _209MinimumSizeSubarraySum ();
		 int nums[]={1,1};
		 System.out.println(A.minSubArrayLen(10, nums));
	}
}

//question:
	//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	//
	//For example, given the array [2,3,1,2,4,3] and s = 7,
	//the subarray [4,3] has the minimal length under the problem constraint.
	//
	//click to show more practice.
	//
	//Credits:
	//Special thanks to @Freezen for adding this problem and creating all test cases.
	//
