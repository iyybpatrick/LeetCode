
public class _80RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] nums) {
        if (nums == null ) return 0;
        if (nums.length <= 2) return nums.length;
        int start = 2;
        for (int i = 2; i < nums.length; i++){
        	if (nums[i] == nums[start -2])
        		continue;
        	nums[start] = nums[i];
        	start++;
        }
        return start;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_80RemoveDuplicatesfromSortedArrayII A =new _80RemoveDuplicatesfromSortedArrayII();
		int [] nums = {1,2,2,2,2,2,2,3,3,3,4,4,4};
		int count = A.removeDuplicates(nums);
		for (int i = 0 ; i < count; i++){
			System.out.print(nums[i]+ " ");
		}
	}

}

//question:
	//Follow up for "Remove Duplicates":
	//What if duplicates are allowed at most twice?
	//
	//For example,
	//Given sorted array nums = [1,1,1,2,2,3],
	//
	//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
	//
