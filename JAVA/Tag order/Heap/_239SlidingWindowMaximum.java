/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return new int[]{};
        int []res = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        int pos = 0;
        for (int i = 0; i < nums.length; i++){
            if (!deque.isEmpty() && deque.peek() <= i - k){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1){
                res[pos++] = nums[deque.peekFirst()];
            }
        }//for i
        return res;
    }

    public static void main(String[] args){
        _239SlidingWindowMaximum A =new _239SlidingWindowMaximum();
        int []nums = {1,3,-1,-3,5,3,6,7};
        int [] res =A.maxSlidingWindow(nums, 3);
        for (int rs : res){
            System.out.print(rs +" ");
        }
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        que.add(6);
        que.add(2);
        que.add(8);
        que.poll();
        System.out.println(que.peek());
    }
}

//question:
//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//        For example,
//        Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//        Window position                Max
//        ---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//        Therefore, return the max sliding window as [3,3,5,5,6,7].