
public class _55JumpGame {
	
	public boolean canJump(int[] nums) {
        int len=nums.length;
        int farthest=nums[0];
        for(int i=0;i<=farthest&&farthest<=(len-1);i++){
        	if(i+nums[i]>farthest)
        		farthest=i+nums[i];
        }
        if(farthest>=len-1)
        	return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_55JumpGame A=new _55JumpGame ();
		int []a={2,3,1,1,4};
		int []a1={3,2,1,0,4};
		int []a2={2};
		System.out.println(A.canJump(a2));
	}

}

//question

		//Given an array of non-negative integers, you are initially positioned at the first index of the array.
		//
		//Each element in the array represents your maximum jump length at that position.
		//
		//Determine if you are able to reach the last index.
		//
		//For example:
		//A = [2,3,1,1,4], return true.
		//
		//A = [3,2,1,0,4], return false.