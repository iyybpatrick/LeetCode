/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _215KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int num : nums){
            queue.offer(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
    public static void main(String[] args){
        _215KthLargestElementInAnArray A =new _215KthLargestElementInAnArray();
        int[]nums = {1,5,6,3,7,12};
        System.out.println(A.findKthLargest(nums, 2));
    }
}

//question:
    //Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    //
    //        For example,
    //        Given [3,2,1,5,6,4] and k = 2, return 5.
    //
    //        Note:
    //        You may assume k is always valid, 1 ≤ k ≤ array's length.