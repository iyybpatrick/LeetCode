
public class _154FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while ( low +1 <high ){
        	int mid= low + (high-low)/2;
        	if ( nums[mid] == nums[high]){
        		high--;
        	}else if (nums[mid] > nums[high]){
        		low=mid;
        	}else {
        		high=mid;
        	}
        }//while
        if (nums[low] <=nums[high]){
        	return nums[low];
        }else {
        	return nums[high];
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_154FindMinimumInRotatedSortedArrayII A=new _154FindMinimumInRotatedSortedArrayII();
		int nums[] = {6,7,8,2,4,4,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,6,6};
		System.out.println(A.findMin(nums));
	}

}

//question:
	//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	//
	//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	//
	//Find the minimum element.
	//
	//The array may contain duplicates.

