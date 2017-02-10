
public class _34SearchforaRange {

	public int[] searchRange(int[] nums, int target) {
		int []result={-1,-1};
        int len=nums.length;
        if(len==0)
        	return result;
        int i,j;
        for(i=0;i<len;i++){
        	if(nums[i]==target){
        		result[0]=i;
        		break;
        	}//if	
        }//for
        for(j=len-1;j>=0;j--){
        	if(nums[j]==target){
        		result[1]=j;
        		break;
        	}//if
        }//for
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_34SearchforaRange A=new _34SearchforaRange();
		int []a={1};
		int []result=A.searchRange(a, 1);
		System.out.println(result[0]+"  "+result[1]);
	}

}

// question:

		//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
		//
		//Your algorithm's runtime complexity must be in the order of O(log n).
		//
		//If the target is not found in the array, return [-1, -1].
		//
		//For example,
		//Given [5, 7, 7, 8, 8, 10] and target value 8,
		//return [3, 4].