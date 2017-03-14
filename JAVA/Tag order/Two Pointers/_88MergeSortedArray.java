
public class _88MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int end1 = m - 1;
		int end2 = n - 1;
		int k = m + n - 1;
		while (end1 >=0 && end2 >=0){
			if (nums1[end1] > nums2[end2]){
				nums1[k--] = nums1[end1--]; 
			}else{
				nums1[k--] = nums2[end2--];
			}
		}//while
		while (end2 >=0){
			nums1[k--] = nums2[end2--];
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_88MergeSortedArray A =new _88MergeSortedArray();
		int[]nums1 = {2,5,7,10,12,0,0,0,0,0,0,0,0,0,0,0,0};
		int[]nums2 = {3,4,6,8,10,11,12};
		A.merge(nums1, 5, nums2, 7);
		for (int num : nums1){
			System.out.print(num+" ");
		}
	}

}

//question:
	//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	//
	//Note:
	//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
	//
