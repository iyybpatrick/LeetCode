
public class _410SplitArrayLargestSum {

	 public int splitArray(int[] nums, int m) {
		 if (nums == null ) return 0;
		 int max = 0;
		 long sum = 0;
		 for (int i=0; i< nums.length; i++){
			sum += nums[i];
			max = Math.max(max, nums[i]);
		 }//for
		 if ( m == 1) return (int)sum;
		 
		 long low = max, high = sum;
		 while ( low <= high){
			 long mid = low + (high - low)/2;
			 if (isValid (nums, mid, m)){
				low = mid +1; 
			 }else{
				 high = mid -1;
			 }
		 }//while
		 return (int)low;
	 }
	 
	private boolean isValid(int[] nums, long target, int m) {
		// TODO Auto-generated method stub
		int count = 1;
		int sum = 0;
		for (int i=0; i < nums.length; i++){
			sum += nums[i];
			if (sum > target){
				count++;
				sum = nums[i];
			}//if
			if (count > m){
				return true;
			}//if
		}//for

			return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_410SplitArrayLargestSum  A= new _410SplitArrayLargestSum ();
		int nums[] = {7,2,5,10,8,12};
		System.out.println(A.splitArray(nums, 3));
	}

}

//question:
	//Given an array which consists of non-negative integers and an integer m,
	//you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
	//
	//Note:
	//If n is the length of array, assume the following constraints are satisfied:
	//
	//1 ≤ n ≤ 1000
	//1 ≤ m ≤ min(50, n)
	//Examples:
	//
	//Input:
	//nums = [7,2,5,10,8]
	//m = 2
	//
	//Output:
	//18
	//
	//Explanation:
	//There are four ways to split nums into two subarrays.
	//The best way is to split it into [7,2,5] and [10,8],
	//where the largest sum among the two subarrays is only 18.