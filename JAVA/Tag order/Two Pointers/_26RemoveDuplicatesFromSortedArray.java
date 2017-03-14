
public class _26RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        for (int i = 1 ; i<nums.length; i++){
        	if (nums[i] != nums[count - 1]){
        		nums[count++] = nums[i];	
        	}
        }//for
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_26RemoveDuplicatesFromSortedArray A =new _26RemoveDuplicatesFromSortedArray();
		int []nums = {1,2,2,2,3,4,5,5,6,6};
		System.out.println(A.removeDuplicates(nums));
	}

}

//question:
	//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	//
	//Do not allocate extra space for another array, you must do this in place with constant memory.
	//
	//For example,
	//Given input array nums = [1,1,2],
	//
	//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
