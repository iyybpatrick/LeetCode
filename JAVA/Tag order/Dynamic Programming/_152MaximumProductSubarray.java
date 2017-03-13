
public class _152MaximumProductSubarray {

	public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int result = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++){
        	if (nums[i] < 0){
        		int temp = max;
        		max = min;
        		min = temp;
        	}//if
        	max = Math.max(nums[i], max * nums[i]);
        	min = Math.min(nums[i], min * nums[i]);
        	result = Math.max(max, result);
        }//for
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_152MaximumProductSubarray A =new _152MaximumProductSubarray();
		int []nums = {-4,-3,-2};
		System.out.println(A.maxProduct(nums));
	}
}

//question:
	//Find the contiguous subarray within an array (containing at least one number) which has the largest product.
	//
	//For example, given the array [2,3,-2,4],
	//the contiguous subarray [2,3] has the largest product = 6.