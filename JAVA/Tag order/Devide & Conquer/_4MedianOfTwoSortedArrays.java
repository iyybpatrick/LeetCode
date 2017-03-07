import java.util.*;
public class _4MedianOfTwoSortedArrays {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 if (nums1 == null  && nums2 == null) return 0;
		 if (nums1.length == 0 && nums2.length == 0) return 0;
		 int len = nums1.length + nums2.length;
		 if (len %2 != 0){
			 return (double) FindKth(nums1, nums2, 0, 0, len/2 + 1);
		 }else{
			 int first = FindKth(nums1, nums2, 0, 0, len/2);
			 int second = FindKth(nums1, nums2, 0, 0, len/2 +1);
			 return (first + second)/2.0;
		 }
	 }
	private int FindKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
		// TODO Auto-generated method stub
		if (start1 >= nums1.length){
			return nums2[start2 + k -1];
		}
		if (start2 >= nums2.length){
			return nums1[start1 + k -1];
		}
		if (k == 1){
			return Math.min(nums1[start1], nums2[start2]);
		}
		int key1 = start1 + k/2 -1 >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + k/2 -1];
		int key2 = start2 +k/2 -1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + k/2 -1];
		if( key1 >key2){
			return FindKth(nums1, nums2, start1, start2 + k/2, k - k/2);
		}else{
			return FindKth(nums1, nums2, start1 +k/2, start2, k - k/2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_4MedianOfTwoSortedArrays A = new _4MedianOfTwoSortedArrays();
		int nums1[] = {};
		int nums2[] = {};
		System.out.println(A.findMedianSortedArrays(nums1, nums2));
		
	}

}

//question:
	//There are two sorted arrays nums1 and nums2 of size m and n respectively.
	//
	//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	//
	//Example 1:
	//nums1 = [1, 3]
	//nums2 = [2]
	//
	//The median is 2.0
	//Example 2:
	//nums1 = [1, 2]
	//nums2 = [3, 4]
	//
	//The median is (2 + 3)/2 = 2.5