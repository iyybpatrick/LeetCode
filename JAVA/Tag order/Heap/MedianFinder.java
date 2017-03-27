/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        big.offer(num);
        small.offer( - big.poll());
        if (small.size() > big.size()){
            big.offer( - small.poll());
        }
    }

    public double findMedian() {
        return big.size() > small.size() ?
                big.peek() : (big.peek() - small.peek())/2.0;
    }

    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(3);
        obj.addNum(4);
        obj.addNum(7);
        obj.addNum(12);
        System.out.println(obj.findMedian());
    }
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

}
