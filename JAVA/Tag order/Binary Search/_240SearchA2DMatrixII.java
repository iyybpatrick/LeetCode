
public class _240SearchA2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = row-1; i>=0;i--){
        	for (int j=0; j<col; j++){
        		if (target == matrix[i][j]){
        			return true;
        		}else if (target < matrix[i][j]){
        			break;
        		}else {
        			continue;
        		}
        	}
        }//for
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_240SearchA2DMatrixII A= new _240SearchA2DMatrixII();
		int matrix[][]= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}};
		System.out.println(A.searchMatrix(matrix, 13));
	}

}

//question:
	//Write an efficient algorithm that searches for a value in an m x n matrix. 
	//This matrix has the following properties:
	//
	//Integers in each row are sorted in ascending from left to right.
	//Integers in each column are sorted in ascending from top to bottom.
	//For example,
	//
	//Consider the following matrix:
	//
	//[
	//  [1,   4,  7, 11, 15],
	//  [2,   5,  8, 12, 19],
	//  [3,   6,  9, 16, 22],
	//  [10, 13, 14, 17, 24],
	//  [18, 21, 23, 26, 30]
	//]
	//Given target = 5, return true.
	//
	//Given target = 20, return false.