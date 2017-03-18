import java.util.*;
public class _347TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < k) return res;
        Map <Integer, Integer> map = new HashMap<>();
        for (int num : nums){
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int number : map.keySet()){
        	int frequency = map.get(number);
        	if (bucket[frequency] == null){
        		bucket[frequency] = new ArrayList<>();
        	}
    		bucket[frequency].add(number);
        }//for
        for (int i = nums.length; i >=0 && res.size() < k; i--){
        	if (bucket[i] != null){
        		res.addAll(bucket[i]);
        	}
        }//for
        return res;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_347TopKFrequentElements A = new _347TopKFrequentElements();
		int []nums = {1,1,1,2,2,3,4,4,4,4,5,5,5,5,5};
		List<Integer> res = A.topKFrequent(nums, 2);
		System.out.print(res);
	}

}

//question:
	//Given a non-empty array of integers, return the k most frequent elements.
	//
	//For example,
	//Given [1,1,1,2,2,3] and k = 2, return [1,2].
	//
	//Note: 
	//You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	//Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
