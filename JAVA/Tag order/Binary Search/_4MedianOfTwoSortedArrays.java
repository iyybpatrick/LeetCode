
public class _4MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len= nums1.length + nums2.length;
        if (len % 2 !=0){
        	return find_kth(nums1,nums2,0,0,len/2+1);
        }
        else{
        	return (find_kth(nums1,nums2,0,0,len/2) + find_kth(nums1,nums2,0,0,len/2+1))/2.0;
        }
    }
	private int find_kth(int[] nums1, int[] nums2, int start1, int start2, int k) {
		// TODO Auto-generated method stub
		if (start1 >= nums1.length){
			return nums2[start2 + k - 1];
		}
		if (start2 >= nums2.length){
			return nums1[start1+ k - 1];
		}
		if (k == 1){
			return Math.min(nums1[start1], nums2[start2]);
		}
		int A_key = start1+k/2 -1 < nums1.length ?  nums1[start1+k/2-1] : Integer.MAX_VALUE;
		int B_key = start2+k/2 -1 < nums2.length ?  nums2[start2+k/2-1] : Integer.MAX_VALUE;
		
		if (A_key > B_key){
			return find_kth (nums1, nums2, start1, start2+k/2, k-k/2);
		}//if
		else{
			return find_kth (nums1, nums2, start1+k/2, start2, k-k/2);
		}//else
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {1,3};
		int nums2[] = {2};
		_4MedianOfTwoSortedArrays A=new _4MedianOfTwoSortedArrays();
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
