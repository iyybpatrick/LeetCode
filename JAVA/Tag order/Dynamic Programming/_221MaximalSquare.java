
public class _221MaximalSquare {

	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] info = new int[m + 1][n + 1];
        for (int i = 1; i <= m ; i++){
        	for (int j = 1; j <= n; j++){
        		if (matrix[i - 1][j - 1] == '1'){
        		info[i][j] = Math.min(Math.min(info[i-1][j-1], info[i-1][j]), info[i][j-1]) + 1;
        		result = Math.max(result, info[i][j]);
        		}
        	}
        }//for
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_221MaximalSquare A = new _221MaximalSquare();
		char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
		System.out.println(A.maximalSquare(matrix));
	}

}

//question:
	//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
	//
	//For example, given the following matrix:
	//
	//1 0 1 0 0
	//1 0 1 1 1
	//1 1 1 1 1
	//1 0 0 1 0
	//Return 4.