
public class _153FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
	        if (nums == null || nums.length == 0) return -1;
	        int low = 0;
	        int high= nums.length-1;
	        int target=nums[nums.length-1];
	        while (low +1 < high){
	        	int mid = low + (high-low)/2;
	        	if (nums[mid] >= target){
	        		low=mid;
	        	}else{
	        		high=mid;
	        	}
	        }//while
	        if (nums[low]<=target){
	        	return nums[low];
	        }else {
	        	return nums[high];
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_153FindMinimumInRotatedSortedArray A=new _153FindMinimumInRotatedSortedArray();
		int nums[]= {1,2};
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
	//You may assume no duplicate exists in the array.