
public class _136SingleNumber {
	
	public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
        	ans ^= nums[i];
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_136SingleNumber  A =new _136SingleNumber ();
		int[] nums = {1,3,5,1,5};
		System.out.println(A.singleNumber(nums));
	}

}
//question:
	//Given an array of integers, every element appears twice except for one. Find that single one.