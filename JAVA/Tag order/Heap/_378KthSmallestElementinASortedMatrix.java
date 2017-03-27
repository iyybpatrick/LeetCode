/**
 * Created by YuebinYang on 2017/3/27.
 */
import java.util.*;
public class _378KthSmallestElementinASortedMatrix {

    public class Element{
        private int x;
        private int y;
        private int val;
        Element(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return 0;

        PriorityQueue<Element> queue = new PriorityQueue<>(matrix.length, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < matrix.length; i++){
            queue.offer( new Element(0, i, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++){
            Element cur = queue.poll();
            if (cur.x < matrix[0].length - 1){
                queue.offer(new Element(cur.x + 1, cur.y, matrix[cur.y][cur.x + 1]));
            }
        }
        return queue.peek().val;

    }
    public static void main(String[] args){
        _378KthSmallestElementinASortedMatrix A =new _378KthSmallestElementinASortedMatrix();
        int matrix[][]= {{1,5,9},{10,11,13},{7,8,15}};
        System.out.println(A.kthSmallest(matrix, 5));
    }
}


//question:
//Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//        Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//        Example:
//
//        matrix = [
//        [ 1,  5,  9],
//        [10, 11, 13],
//        [12, 13, 15]
//        ],
//        k = 8,
//
//        return 13.
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ n2.