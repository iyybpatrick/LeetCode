/**
 * Created by YuebinYang on 2017/3/27.
 */
import java.util.*;
public class _407TrappingRainWaterII {

    public class Element{
        private int row;
        private int col;
        private int val;
        Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <=2) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        int sum = 0;
        PriorityQueue<Element> queue = new PriorityQueue<>(row * 2 + col * 2,new Comparator<Element>(){
            public int compare (Element o1, Element o2){
                return o1.val - o2.val;
            }
        });

        boolean [][]visited = new boolean[row][col];
        for (int i = 0; i < row; i++){
            queue.offer(new Element (i, 0, heightMap[i][0]));
            queue.offer(new Element (i, col - 1, heightMap[i][col - 1]));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        for (int j = 1; j < col - 1; j++){
            queue.offer(new Element(0, j, heightMap[0][j]));
            queue.offer(new Element(row - 1, j, heightMap[row - 1][j]));
            visited[0][j] =true;
            visited[row - 1][j] = true;
        }

        while (!queue.isEmpty()){
            Element cur = queue.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            if (curRow > 1 && visited[curRow - 1][curCol] == false){
                if (heightMap[curRow - 1][curCol] < cur.val) {
                    sum += cur.val - heightMap[curRow - 1][curCol];
                    queue.offer(new Element(curRow - 1, curCol, cur.val));
                }else{
                    queue.offer(new Element(curRow - 1, curCol, heightMap[curRow - 1][curCol]));
                }
                    visited[curRow - 1][curCol] = true;


            }

            if (curCol > 1 && visited[curRow][curCol - 1] == false){
                if (heightMap[curRow][curCol - 1] < cur.val){
                    sum += cur.val - heightMap[curRow][curCol - 1];
                    queue.offer(new Element(curRow, curCol - 1, cur.val));
                }else{
                    queue.offer(new Element(curRow, curCol - 1, heightMap[curRow][curCol - 1]));
                }
                visited[curRow][curCol - 1] = true;

            }

            if (curRow < row - 2 && visited[curRow + 1][curCol] == false){
                if (heightMap[curRow + 1][curCol] < cur.val) {
                    sum += cur.val - heightMap[curRow + 1][curCol];
                    queue.offer(new Element(curRow + 1, curCol, cur.val));
                }else{
                    queue.offer(new Element(curRow + 1, curCol, heightMap[curRow + 1][curCol]));
                }
                visited[curRow + 1][curCol] = true;


            }

            if (curCol < col - 2 && visited[curRow][curCol + 1] == false){
                if (heightMap[curRow][curCol + 1] < cur.val){
                    sum += cur.val - heightMap[curRow][curCol + 1];
                    queue.offer(new Element(curRow, curCol + 1, cur.val));
                }else{
                    queue.offer(new Element(curRow, curCol + 1, heightMap[curRow][curCol + 1]));
                }
                visited[curRow][curCol + 1] = true;
            }

        }//while
        return sum;
    }


    public static void main(String[] args){
        _407TrappingRainWaterII A =new _407TrappingRainWaterII();
    }
}

//question:
//Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
//
//        Note:
//        Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
//
//        Example:
//
//        Given the following 3x6 height map:
//        [
//        [1,4,3,1,3,2],
//        [3,2,1,3,2,4],
//        [2,3,3,2,3,1]
//        ]
//
//        Return 4.