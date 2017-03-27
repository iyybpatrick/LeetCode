/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _347TopKFrequentElements {

    //public List<Integer> topKFrequent(int[] nums, int k) {
    //    List<Integer> res =new ArrayList<>();
    //    if (nums == null || nums.length == 0 ) return res;
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for (int num : nums){
    //        map.put(num, map.getOrDefault(num, 0) + 1);
    //    }
    //    List<Integer>[] bucket = new ArrayList[nums.length + 1];
    //    for (int set : map.keySet()){
    //        int frequency = map.get(set);
    //        if (bucket[frequency] == null){
    //            bucket[frequency] = new ArrayList<>();
    //        }
    //        bucket[frequency].add(set);
    //    }//for
    //
    //    for (int i = nums.length; i >= 0 && res.size() < k; i--){
    //        if (bucket[i] !=null){
    //            res.addAll(bucket[i]);
    //        }
    //    }
    //    return res;
    //}

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res =new ArrayList<>();
        if (nums == null || nums.length == 0  || k <= 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        PriorityQueue<Map.Entry<Integer, Integer>> maxheap =new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxheap.add(entry);
        }

        while (res.size() < k){
            Map.Entry<Integer, Integer> entry = maxheap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
    public static void main(String[] args){
        _347TopKFrequentElements A =new _347TopKFrequentElements();
        int []nums = {1,1,1,2,2,3};
        List<Integer> res = A.topKFrequent(nums, 2);
        System.out.println(res);
    }
}

//question:
//Given a non-empty array of integers, return the k most frequent elements.
//
//        For example,
//        Given [1,1,1,2,2,3] and k = 2, return [1,2].
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
