import java.util.*;
public class _217ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length; i++){
        	if (set.contains(nums[i])){
        		return true;
        	}else{
        		set.add(nums[i]);
        	}
        }//for
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_217ContainsDuplicate A =new _217ContainsDuplicate();
		int []nums = {1,4,6,3,4,2,7};
		System.out.println(A.containsDuplicate(nums));
 	}

}

//question:
	//Given an array of integers, find if the array contains any duplicates. 
	//Your function should return true if any value appears at least twice in the array,
	//		and it should return false if every element is distinct.

