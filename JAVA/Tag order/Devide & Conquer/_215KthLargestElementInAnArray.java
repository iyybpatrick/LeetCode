import java.util.*;
public class _215KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums ){
        	queue.offer(num);
        	if (queue.size() > k){
        		queue.poll();
        	}
        }//for
        return queue.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_215KthLargestElementInAnArray A = new _215KthLargestElementInAnArray();
		int nums[] = {1,4,6,8,9};
		System.out.println(A.findKthLargest(nums, 5));
	}

}

//question:
	//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
	//
	//For example,
	//Given [3,2,1,5,6,4] and k = 2, return 5.
	//
	//Note: 
	//You may assume k is always valid, 1 ≤ k ≤ array's length.
