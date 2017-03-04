import java.util.*;
public class _448FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new LinkedList<>();
        if (nums == null) return result;
        int i = 0;
        int len = nums.length;
        while (i < len){
        	if (nums[i] >= 1 && nums[i] <= len && nums[i] != (i+1) && nums[nums[i]-1] != nums[i]){
        		int temp = nums[i];
        		nums[i] = nums[temp-1];
        		nums[temp-1] = temp;
        	}else{
        		i++;
        	}
        }//while
        for (i=0; i < len; i++){
        	if (nums[i] != i+1){
        		result.add(i+1);
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_448FindAllNumbersDisappearedInAnArray A =new _448FindAllNumbersDisappearedInAnArray();
		int nums[]= {4,3,2,7,8,2,3,1};
		List<Integer> result = A.findDisappearedNumbers(nums);
		System.out.println(result);
	}

}

//question;
	//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
	//some elements appear twice and others appear once.
	//
	//Find all the elements of [1, n] inclusive that do not appear in this array.
	//
	//Could you do it without extra space and in O(n) runtime?
	//		You may assume the returned list does not count as extra space.
	//
	//Example:
	//
	//Input:
	//[4,3,2,7,8,2,3,1]
	//
	//Output:
	//[5,6]