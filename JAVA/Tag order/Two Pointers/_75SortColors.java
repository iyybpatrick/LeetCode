
public class _75SortColors {

	public void sortColors(int[] nums) {
        if (nums == null) return;
        int len = nums.length;
        int zero = 0;
        int second = len -1;
        for (int i = 0; i < len; i++){
        	while (i <= second && nums[i] == 2) {
        		nums[i] = nums[second];
        		nums[second--] = 2;
        	}
        	while (i >= zero && nums[i] == 0) {
        		nums[i] = nums[zero];
        		nums[zero++] = 0;
        	}
        }//for 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,1,2,0,1,0,1};
		_75SortColors A =new  _75SortColors();
		A.sortColors(nums);
		for (int i : nums){
			System.out.print(i +" ");
		}
	}

}

//question:
	//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	//
	//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	//
	//Note:
	//You are not suppose to use the library's sort function for this problem.
	//
	//click to show follow up.
	//
	//Follow up:
	//A rather straight forward solution is a two-pass algorithm using counting sort.
	//First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	//
	//Could you come up with an one-pass algorithm using only constant space?