
public class _35SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        int len=nums.length;
        if(len==0)
        	return 0;
        int start=0,end=len-1;
        while(start<=end){
        int mid=start+((end-start)>>1);
        if(nums[mid]==target){
        	return mid;
        }
        else if(nums[mid]>target){
        	end=mid-1;
        }
        else{
        	start=mid+1;
       }  	
       }//while
        return start;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_35SearchInsertPosition A=new _35SearchInsertPosition();
		int []a={0};
		int insert=A.searchInsert(a, -1);
		System.out.println(insert);
	}

}

// Question:
		//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
		//
		//You may assume no duplicates in the array.
		//
		//Here are few examples.
		//[1,3,5,6], 5 → 2
		//[1,3,5,6], 2 → 1
		//[1,3,5,6], 7 → 4
		//[1,3,5,6], 0 → 0