import java.util.Arrays;

public class _16_3SumClosest {

	 public int threeSumClosest(int[] nums, int target) {
	        if (nums == null ||nums.length <= 2 ) return 0;
	        int res = Integer.MAX_VALUE;
;	        int dif = Integer.MAX_VALUE;
	        int sum = 0;
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length - 2; i++){
	        	if (i != 0 && nums[i] == nums[i-1]) continue;
	        	sum = target - nums[i];
	        	int start = i + 1;
	        	int end = nums.length -1;
	        	while (start < end){
	        		int curSum = nums[start] + nums[end];
	        		if (Math.abs(curSum - sum) < dif){
	        			res = curSum + nums[i];
	        			dif = Math.abs(curSum - sum);
	        		}
	        		if (curSum < sum){
	        			 start ++;
	        		}else{
	        			 end --;
	        		}
	        	}//while
	        }//for
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_16_3SumClosest A = new _16_3SumClosest();
		int [] nums = {0,0,1};
		System.out.println(A.threeSumClosest(nums, 0));
	}

}

//question:
	//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	//
	//For example, given array S = {-1 2 1 -4}, and target = 1.
	//
	//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).