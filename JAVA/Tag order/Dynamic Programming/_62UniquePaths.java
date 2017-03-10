
public class _62UniquePaths {

	 public int uniquePaths(int m, int n) {
	        if (m == 0 || n == 0) return 0;
	        int []dp = new int[n];
	        for (int i = 0; i < n; i++){
	        	dp[i] = 1;
	        }
	        for (int i = 1; i < m; i++){
	        	for (int j = 1; j < n; j++){
	        		dp[j] = dp[j-1] + dp[j];
	        	}
	        }//for
	        return dp[n - 1];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_62UniquePaths A = new _62UniquePaths();
		System.out.print(A.uniquePaths(2, 3));
	}

}

//question:
	//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	//
	//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	//
	//How many possible unique paths are there?