
public class _74SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix == null || matrix.length == 0) return false;
        if ( matrix[0] == null || matrix[0].length == 0) return false;
        int high = matrix.length-1;
        int low=0;
        int row,col;
        while ( low + 1 < high){
        	int mid= low +(high-low)/2;
        	if (matrix[mid][0] == target){
        		return true;
        	}else if (matrix[mid][0] < target){
        		low=mid;
        	}else {
        		high=mid;
        	}
        }//while
        if (matrix[high][0] <= target){
        	row = high;
        }else if (matrix[low][0] <= target){
        	row=low;
        }else {
        	return false;
        }
        low=0;
        high=matrix[0].length-1;
        while (low + 1 < high){
        	int mid =low + (high-low)/2;
        	if (matrix[row][mid] == target){
        		return true;
        	}else if (matrix[row][mid] < target){
        		low = mid;
        	}else {
        		high=mid;
        	}
        }//while
        if (matrix[row][low] == target || matrix[row][high] == target){
        	return true;
        }else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_74SearchA2DMatrix A=new _74SearchA2DMatrix();
		int matrix[][]={{1,2,4,6},{8,9,12,15},{18,20,21,22}};
		System.out.print(A.searchMatrix(matrix, 20));
	}

}

//question:
	//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	//
	//Integers in each row are sorted from left to right.
	//The first integer of each row is greater than the last integer of the previous row.
	//For example,
	//
	//Consider the following matrix:
	//
	//[
	//  [1,   3,  5,  7],
	//  [10, 11, 16, 20],
	//  [23, 30, 34, 50]
	//]
	//Given target = 3, return true.