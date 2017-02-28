import java.util.*;
public class _378KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
        if ( matrix == null 
        		|| matrix.length == 0
        		|| matrix[0] == null
        		|| matrix[0].length == 0){
        return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Elements> queue = new PriorityQueue<Elements>();
        
        for (int i=0; i <col; i++){
        	queue.offer(new Elements (i, 0, matrix[i][0]));
        }//for
        
        for (int j=0; j< k - 1; j++){
        	Elements temp = queue.poll();
        	if (temp.y == col-1){
        		continue;
        	}//if
        	queue.offer(new Elements (temp.x, temp.y +1 , matrix[temp.x][temp.y + 1]));
        }//for
        
      return queue.poll().val;
    }
	
	public class Elements implements Comparable<Elements>{
		private int x;
		private int y;
		private int val;
		Elements (int x,int y,int val){
			this.x=x;
			this.y=y;
			this.val=val;
		}//Constructor
		
		@Override
		public int compareTo(Elements that) {
			// TODO Auto-generated method stub
			return this.val - that.val;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_378KthSmallestElementInASortedMatrix A=new _378KthSmallestElementInASortedMatrix();
		int matrix[][]= {{1,5,9},{10,11,13},{7,8,15}};
		System.out.println(A.kthSmallest(matrix, 5));
		
	}

}

//question:
	//Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
	//
	//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
	//
	//Example:
	//
	//matrix = [
	//   [ 1,  5,  9],
	//   [10, 11, 13],
	//   [12, 13, 15]
	//],
	//k = 8,
	//
	//return 13.
	//Note: 
	//You may assume k is always valid, 1 ≤ k ≤ n2.