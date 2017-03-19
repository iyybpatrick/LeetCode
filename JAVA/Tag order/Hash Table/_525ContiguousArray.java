import java.util.*;
public class _525ContiguousArray {

	public int findMaxLength(int[] nums) {
       if (nums == null) return 0;
       for (int i = 0; i < nums.length; i++){
    	   if (nums[i] == 0) 
    		   nums[i] = -1;
       }//for
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
       int sum = 0;
       int max = 0;
       for (int i = 0; i < nums.length; i++){
    	   sum += nums[i];
    	   if (map.containsKey(sum)){
    		   max = Math.max(max, i - map.get(sum));
    	   }else{
    		   map.put(sum, i);
    	   }
       }//for
       return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_525ContiguousArray  A = new _525ContiguousArray ();
		int [] nums = {1,0,1};
		System.out.println(A.findMaxLength(nums));
	}

}

//question:
	//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
	//
	//Example 1:
	//Input: [0,1]
	//Output: 2
	//Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
	//Example 2:
	//Input: [0,1,0]
	//Output: 2
	//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
	//Note: The length of the given binary array will not exceed 50,000.
	//
