import java.util.ArrayList;
import java.util.List;

public class _80RemoveDuplicatesfromSortedArrayII {
	
	private int num_after;
	
	public int removeDuplicates(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        result.add(path);
        if(nums.length<=2)
        	return nums.length;
        
        int num_after=2;
       for(int i=2;i<nums.length;i++){
    	   if(nums[i]!=nums[num_after-2]){
    		   nums[num_after++]=nums[i];
    	   }//if
       }//for
        return num_after;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_80RemoveDuplicatesfromSortedArrayII A=new _80RemoveDuplicatesfromSortedArrayII();
		int []a={1,1,1,3,3,3,2,2,2,2};
		System.out.println(A.removeDuplicates(a));
	}

}
//question:
	//Follow up for "Remove Duplicates":
	//What if duplicates are allowed at most twice?
	//
	//For example,
	//Given sorted array nums = [1,1,1,2,2,3],
	//
	//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
	//It doesn't matter what you leave beyond the new length.