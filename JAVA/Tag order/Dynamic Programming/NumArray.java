
public class NumArray {
	int []sums;
	public NumArray(int[] nums) {
        if (nums == null) return;
        sums = new int [nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
        	sums[i] = sums[i - 1] + nums[i - 1];
        }//for
        
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {-2,0,3,-5,2,-1};
		NumArray obj = new NumArray(nums);
		System.out.println(obj.sumRange(0, 2));
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

//question:
	//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
	//
	//Example:
	//Given nums = [-2, 0, 3, -5, 2, -1]
	//
	//sumRange(0, 2) -> 1
	//sumRange(2, 5) -> -1
	//sumRange(0, 5) -> -3