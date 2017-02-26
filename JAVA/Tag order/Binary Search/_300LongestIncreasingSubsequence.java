
public class _300LongestIncreasingSubsequence {

	
	public int lengthOfLIS(int[] nums) {
        int tails[]= new int[nums.length];
        int sub_num = 0;
        for ( int x : nums){
        	int i=0, j=sub_num;
        	while (i != j){
        		int mid = i + (j-i)/2;
        		if (x <= tails[mid]){
        			j = mid;
        		}else{
        			i = mid+1;
        		}
        	}//while
        	tails[i] = x;
        	if ( i == sub_num) sub_num++;
        }//for
        return sub_num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_300LongestIncreasingSubsequence A= new _300LongestIncreasingSubsequence();
		int nums[]= {10,9,2,5,3,7,101,18};
		System.out.println(A.lengthOfLIS(nums));
	}

}

//question:
	//Given an unsorted array of integers, find the length of longest increasing subsequence.
	//
	//For example,
	//Given [10, 9, 2, 5, 3, 7, 101, 18],
	//The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	//
	//Your algorithm should run in O(n2) complexity.
	//
	//Follow up: Could you improve it to O(n log n) time complexity?