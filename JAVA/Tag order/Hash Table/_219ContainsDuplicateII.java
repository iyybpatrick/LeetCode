import java.util.*;
public class _219ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        Set <Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
        	if (i > k) set.remove(nums[i - k - 1]);
        	if (!set.add(nums[i])) return true;
        }//for
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//Given an array of integers and an integer k, find out whether there are two distinct 
	//indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

