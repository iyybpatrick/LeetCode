
public class _283MoveZeroes {

	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 ) return;
        int len = nums.length;
        int idx = 0;
        for (int i = 0; i < len; i++){
        	if (nums[i] != 0) nums[idx++] = nums[i];
        }
        for (int i = idx; i < len; i++){
        	nums[i] = 0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_283MoveZeroes A =new _283MoveZeroes();
		int[] nums ={0,1,0,3,12};
		A.moveZeroes(nums);
		for (int num : nums){
			System.out.print(num +" ");
		}
	}

}

//question:
	//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	//
	//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	//
	//Note:
	//You must do this in-place without making a copy of the array.
	//Minimize the total number of operations.
