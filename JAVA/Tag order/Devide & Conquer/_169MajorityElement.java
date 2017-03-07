import java.util.*;
public class _169MajorityElement {

	public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map <Integer, Integer> map = new HashMap<>();
        for (int num : nums){
        	map.put(num, map.getOrDefault(num, 0) +1);
        	if (map.get(num) >= nums.length /2){
        		return num;
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_169MajorityElement A = new _169MajorityElement();
			int nums [] = {6,5,5};
			System.out.println(A.majorityElement(nums));
	}

}

//question:
	//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	//
	//You may assume that the array is non-empty and the majority element always exist in the array.
