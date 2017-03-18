import java.util.*;
public class _349Intersection_ofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) return new int[]{};
		Set<Integer> set = new HashSet<>();
		Set<Integer> intersection = new HashSet<>();
		for (int num : nums1){
			set.add(num);
		}
		for (int num : nums2){
			if (set.contains(num)){
				intersection.add(num);
			}
		}
		int [] res= new int[intersection.size()];
		int i = 0;
		for (int x : intersection){
			res[i++] = x;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_349Intersection_ofTwoArrays A =new _349Intersection_ofTwoArrays();
		int []nums1 = {1,2,2,4};
		int []nums2 = {2,3,4};
		int [] res = A.intersection(nums1, nums2);
		for (int num : res){
			System.out.print(num+" ");
		}
	}

}

//question:
	//Given two arrays, write a function to compute their intersection.
	//
	//Example:
	//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	//
	//Note:
	//Each element in the result must be unique.
	//The result can be in any order.
