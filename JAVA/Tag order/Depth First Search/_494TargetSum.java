
public class _494TargetSum {
	private int count = 0;
	public int findTargetSumWays(int[] nums, int S) {
	        if (nums == null) return 0;        
	        	DFS(nums, 0, S);
	        return count;
	    }
	private void DFS(int[] nums, int start, int s) {
		// TODO Auto-generated method stub
		if (s == 0 && start == nums.length) {
			count++;return;
		}
		if (start == nums.length) return;
		
		DFS(nums, start + 1, s + nums[start]);
		DFS(nums, start + 1, s - nums[start]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_494TargetSum A = new _494TargetSum();
		int [] nums = {1,1,1,1,1};
		System.out.println(A.findTargetSumWays(nums, 3));
	}

}

//question:
	//You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
	//
	//Find out how many ways to assign symbols to make sum of integers equal to target S.
	//
	//Example 1:
	//Input: nums is [1, 1, 1, 1, 1], S is 3. 
	//Output: 5
	//Explanation: 
	//
	//-1+1+1+1+1 = 3
	//+1-1+1+1+1 = 3
	//+1+1-1+1+1 = 3
	//+1+1+1-1+1 = 3
	//+1+1+1+1-1 = 3
	//
	//There are 5 ways to assign symbols to make the sum of nums be target 3.
	//Note:
	//The length of the given array is positive and will not exceed 20.
	//The sum of elements in the given array will not exceed 1000.
	//Your output answer is guaranteed to be fitted in a 32-bit integer.