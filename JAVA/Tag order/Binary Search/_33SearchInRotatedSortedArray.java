
public class _33SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len=nums.length;
        int low=0, high=len-1, mid;
        while (low +1 < high){
        	mid = low + (high-low)/2;
        	if (nums[mid] == target) {
        		return mid;
        	}//if
        	if (nums[mid]>= nums[0]){
        		if (nums[low] <= target && target <= nums[mid] ){
        			high = mid;
        		}//if
        		else {
        			low =mid;
        		}//else
        	}//if
        	else{
        		if ( nums[mid] <= target && target <=nums[high]){
        			low=mid;
        		}//if
        		else{
        			high=mid;
        		}//else
        	}//else if
        }//while
        
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={};
		_33SearchInRotatedSortedArray A=new _33SearchInRotatedSortedArray();
		System.out.println(A.search(nums, 7));
	}

}

//question:
	//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	//
	//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	//
	//You are given a target value to search. If found in the array return its index, otherwise return -1.
	//
	//You may assume no duplicate exists in the array.