import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YuebinYang on 2017/3/27.
 */
import java.util.*;
public class _406QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 ||people[0].length < 2) return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++){
            res.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }

        int[][] result = new int[people.length][2];
        int i = 0;
        for (int[] cur : res){
            result[i][0] = cur[0];
            result[i++][1] = cur[1];
        }
        return result;
    }
    
    public static void main(String[] args){
        _406QueueReconstructionByHeight A =new _406QueueReconstructionByHeight();
        int [][]people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int [][] res= A.reconstructQueue(people);
        for (int [] temp : res){
            System.out.println("["+ temp[0]+ ","+ temp[1] +"]");
        }
    }

}

//question:
//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
//
//        Note:
//        The number of people is less than 1,100.
//
//        Example
//
//        Input:
//        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//        Output:
//        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
