import java.util.*;
public class _1TwoSum {

	public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[]{-1,-1};
        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
        	if (map.containsKey(target - nums[i])){
        		int index1= map.get(target - nums[i]);
        		int []res = new int[]{index1, i};
        		return res;
        	}else{
        		map.put(nums[i], i);
        	}
        }
        return new int[]{-1, -1};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1TwoSum A =new _1TwoSum();
		int []nums = {2, 7, 11, 15};
		int [] res = A.twoSum(nums, 9);
		System.out.println(res[0] +" "+res[1]);
	}

}

//question:
	//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	//
	//You may assume that each input would have exactly one solution, and you may not use the same element twice.
	//
	//Example:
	//Given nums = [2, 7, 11, 15], target = 9,
	//
	//Because nums[0] + nums[1] = 2 + 7 = 9,
	//return [0, 1].