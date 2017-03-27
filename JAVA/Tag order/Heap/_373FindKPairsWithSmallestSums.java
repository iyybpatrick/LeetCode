/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _373FindKPairsWithSmallestSums {


    public class Pair{
        int []pair;
        long sum;
        int idx;
        Pair(int idx, int n1, int n2){
            this.idx = idx;
            sum = (long)n1+ (long)n2;
            pair = new int[]{n1,n2};
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 ) return res;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int)(o1.sum - o2.sum);
            }
        });
        for (int i = 0; i < nums1.length && i < k; i++){
            queue.offer(new Pair(0, nums1[i], nums2[0]));
        }
        for (int i = 1; i <= k && !queue.isEmpty(); i++){
            Pair p = queue.poll();
            res.add(p.pair);
            if (p.idx < nums2.length - 1){
                queue.offer(new Pair(p.idx + 1, p.pair[0], nums2[p.idx + 1]));
            }
        }//for
        return res;
    }

    public static void main(String[] args){
        _373FindKPairsWithSmallestSums A =new _373FindKPairsWithSmallestSums();
        int [] nums1=  {1,1,2};
        int [] nums2= {1,2,3};
        List<int[]> res = A.kSmallestPairs(nums1, nums2, 7);
        for (int[] cur : res){
            System.out.println(cur[0]+" "+cur[1]);
        }
    }
}

//question:
//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//        Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
//        Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
//        Example 1:
//        Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
//
//        Return: [1,2],[1,4],[1,6]
//
//        The first 3 pairs are returned from the sequence:
//        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//        Example 2:
//        Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
//
//        Return: [1,1],[1,1]
//
//        The first 2 pairs are returned from the sequence:
//        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//        Example 3:
//        Given nums1 = [1,2], nums2 = [3],  k = 3
//
//        Return: [1,3],[2,3]
//
//        All possible pairs are returned from the sequence:
//        [1,3],[2,3]