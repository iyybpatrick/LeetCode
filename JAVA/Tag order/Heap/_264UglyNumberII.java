/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _264UglyNumberII {

    public int nthUglyNumber(int n) {
        if (n == 1 ) return 1;
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        queue.offer(1l);
        for (int i =0; i < n - 1; i++){
            long cur = queue.poll();
            while (!queue.isEmpty() && queue.peek() == cur) cur = queue.poll();

            queue.offer(cur * 2);
            queue.offer(cur * 3);
            queue.offer(cur * 5);
        }
        return queue.poll().intValue();
    }

    public static void main(String[] args){
        _264UglyNumberII A= new _264UglyNumberII();
        System.out.println(A.nthUglyNumber(8));
    }
}

//question:
//Write a program to find the n-th ugly number.
//
//        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//
//        Note that 1 is typically treated as an ugly number, and n does not exceed 1690.