
public class _287FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
        if (nums.length <=1) return -1;
        int len = nums.length;
        int start = 1, end = len -1;
        while (start < end){
        	int mid = start + (end-start)/2;
        	int count=0;
        	for(int i=0; i<len; i++){
        		if (nums[i] <= mid){
        			count++;
        		}
        	}
        	if (count > mid){
        		end = mid;
        	}else {
        		start =mid + 1;
        	}
        }
        return start;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_287FindTheDuplicateNumber A=new _287FindTheDuplicateNumber();
		int nums[]= {3,2,5,4,2,1};
		System.out.println(A.findDuplicate(nums));
	}

}

//question:
	//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
	//
	//Note:
	//You must not modify the array (assume the array is read only).
	//You must use only constant, O(1) extra space.
	//Your runtime complexity should be less than O(n2).
	//There is only one duplicate number in the array, but it could be repeated more than once.
	//Credits: