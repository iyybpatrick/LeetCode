
public class _35SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0;
        int high = nums.length-1;
        
        while (low + 1 < high ){
        	int mid = low + (high-low)/2;
        	if (nums[mid] == target){
        		return mid;
        	}else if ( nums[mid]> target){
        		high=mid;
        	}else{
        		low=mid;
        	}
        }//while
        if (nums[high] == target) {
        	return high;
        }else if (nums[high] < target){
        	return high+1;
        }else if ( nums[low] < target) {
        	return high;
        }else return low;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_35SearchInsertPosition A =new _35SearchInsertPosition();
		int nums[] = {1,4,6,7,9};
		System.out.print(A.searchInsert(nums, 10));
	}

}

//question:
	//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	//
	//You may assume no duplicates in the array.
	//
	//Here are few examples.
	//[1,3,5,6], 5 → 2
	//[1,3,5,6], 2 → 1
	//[1,3,5,6], 7 → 4
	//[1,3,5,6], 0 → 0