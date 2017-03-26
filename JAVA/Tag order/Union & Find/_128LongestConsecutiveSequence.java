/**
 * Created by YuebinYang on 2017/3/25.
 */
import java.util.*;
public class _128LongestConsecutiveSequence {

    public class UF{
        private int []list;
        UF(int n ){
            list = new int[n];
            for (int i = 0 ; i < n; i++){
                list[i] = i;
            }
        }
        int FindParent(int p){

            while (p != list[p]){
                list[p] = list[list[p]];
                p = list[p];
            }
            return p;
        }
        void Union (int p, int q) {
            int p1 = FindParent(p);
            int q2 = FindParent(q);
            list[p1] = q2;
        }
        int findMax (){
            int []count = new int[list.length];
            int max = 0;
            for (int i = 0; i < list.length; i++){
                count[FindParent(i)]++;
                max = Math.max(max, count[list[i]]);
            }
            return max;
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map <Integer, Integer> map = new HashMap<>();
        UF uf = new UF(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) continue;

            map.put(nums[i], i);
            if (map.containsKey(nums[i] - 1)){
                uf.Union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)){
                uf.Union(i, map.get(nums[i] + 1));
            }
        }
         return uf.findMax();
    }
        public static void main (String[] args){
            _128LongestConsecutiveSequence A =new _128LongestConsecutiveSequence();
            int [] nums=  {100,4,3,200,1,400,2,7,800,6,123,5};
            System.out.println(A.longestConsecutive(nums));

    }

}

//question:
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//        For example,
//        Given [100, 4, 200, 1, 3, 2],
//        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//        Your algorithm should run in O(n) complexity.
//
//        Subscribe to see which companies asked this question.