
public class _162FindPeakElement {

	public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int low =0;
        int high = nums.length-1;
        while (low +1 < high){
        	int mid =low + (high-low)/2;
        	// increasing
        	if (nums[mid] <=nums[mid+1]){
        		low = mid;
        	}
        	// decreasing
        	else{
        		high = mid;
        	}
        }//while
        if (nums[high] <nums [low])
        	return low;
        else{
        	return high;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_162FindPeakElement A=new _162FindPeakElement();
		int nums[]= {2,3,2,4,3,5,4,3,2,1};
		System.out.println(A.findPeakElement(nums));
	}

}

//question:
	//A peak element is an element that is greater than its neighbors.
	//
	//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
	//
	//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	//
	//You may imagine that num[-1] = num[n] = -∞.
	//
	//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	//
	//click to show spoilers.
	//
	//Credits:
	//Special thanks to @ts for adding this problem and creating all test cases.