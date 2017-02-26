import java.util.*;
public class _349IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> set1=new HashSet<>();
         Set<Integer> intersection =new HashSet<>();
         for (int i=0; i<nums1.length; i++){
        	 set1.add(nums1[i]);
         }//for
         for (int i=0; i<nums2.length; i++){
        	 if (set1.contains(nums2[i])){
        		 intersection.add(nums2[i]);
        	 }
         }//for
         int result[]= new int [intersection.size()];
         int i=0;
         for ( int x : intersection){
        	 result[i++]=x;
         }
         return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_349IntersectionOfTwoArrays A=new _349IntersectionOfTwoArrays();
		int nums1[]= {1,2,4,6,9};
		int nums2[]= {2,3,5,7,9};
		int result []= A.intersection(nums1, nums2);
		for (int x : result){
			System.out.print(x +" ");
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