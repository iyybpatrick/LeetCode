
public class _34SearchForARange {

	public int[] searchRange(int[] nums, int target) {
		int res[]={-1,-1};
        if (nums == null || nums.length == 0){
        	return res;
        }
        int low =0, high=nums.length-1;
        while (low +1 <high){
        	int mid = low+ (high-low)/2;
        	if (nums[mid] == target){
        		high=mid;
        	}else if (nums[mid] <= target){
        		low=mid;
        	}else{
        		high=mid;
        	}
        }//while
        if (nums[low] == target) res[0]=low;
        else if (nums[high] == target) res[0]=high;
        else {
        	res[0]=res[1]=-1;
        	return res;
        }
        
        low=0;
        high=nums.length-1;
        while (low +1 <high){
        	int mid= low+ (high-low)/2;
        	if (nums[mid] == target){
        		low=mid;
        	}
        	else if (nums[mid] <= target){
        		low=mid;
        	}
        	else{
        		high=mid;
        	}
        }//while
        if (target == nums[high]) res[1] =high;
        else if (target == nums[low]) res[1]=low;
        else {
        	res[0]=res[1]=-1;
        	return res;
        }
        
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_34SearchForARange A=new _34SearchForARange();
		int nums[]={1,2,3,4,4,4,5};
		int res[]= A.searchRange(nums, 4);
		System.out.println(res[0]+" "+res[1]);
	}

}

//question:
	//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
	//
	//Your algorithm's runtime complexity must be in the order of O(log n).
	//
	//If the target is not found in the array, return [-1, -1].
	//
	//For example,
	//Given [5, 7, 7, 8, 8, 10] and target value 8,
	//return [3, 4].