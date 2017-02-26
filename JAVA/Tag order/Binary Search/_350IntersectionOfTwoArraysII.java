import java.util.*;
public class _350IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>(); 
        for (int x : nums1){
        	if (map1.containsKey(x)){
        		map1.put(x, map1.get(x) + 1 );
        	}else{
        		map1.put(x, 1);
        	}
        }//for
        
        for (int x : nums2){
        	if (map1.containsKey(x) && map1.get(x) >0){
        		res.add(x);
        		map1.put(x, map1.get(x) -1);
        	}//if
        }//for
        
        int result[]= new int [res.size()];
        int i=0;
        for (int x : res){
        	result[i++] = x;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_350IntersectionOfTwoArraysII A =new _350IntersectionOfTwoArraysII();
		int nums1[]= {1,2,2,4,5,7,7,8};
		int nums2[]= {2,2,4,6,7,7,8,8,8};
		int result[] = A.intersect(nums1, nums2);
		for (int x : result){
			System.out.print(x +" ");
		}
	}

}

//question:
	//Given two arrays, write a function to compute their intersection.
	//
	//Example:
	//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	//
	//Note:
	//Each element in the result should appear as many times as it shows in both arrays.
	//The result can be in any order.
	//Follow up:
	//What if the given array is already sorted? How would you optimize your algorithm?
	//What if nums1's size is small compared to nums2's size? Which algorithm is better?
	//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
