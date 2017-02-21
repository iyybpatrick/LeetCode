
public class _53MaximumSubarray {

	 public int maxSubArray(int[] nums) {
	     int len=nums.length;
	    
	     int s[]=new int[len];
	     s[0]=nums[0];
	     int max=nums[0];
	     for(int i=1;i<len;i++)
	     {
	    	 s[i]=Math.max(s[i-1]+nums[i],nums[i]);
	    	 if(s[i]>max){
	    		 max=s[i];
	    	 }//if
	     }//for
	    return max;
		 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_53MaximumSubarray A=new _53MaximumSubarray();
		int []a={-2,1,-3,4,-1,2,1,-5,4};
		int []a1={-1,2};
		int max=A.maxSubArray(a1);
		System.out.println(max);
	}

}


//question:
	//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	//
	//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	//the contiguous subarray [4,-1,2,1] has the largest sum = 6.