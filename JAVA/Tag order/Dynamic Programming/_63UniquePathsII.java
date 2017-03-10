
public class _63UniquePathsII {

//	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        int []dp = new int[n];
//        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
//        for (int i = 1; i < n; i++){
//        	dp[i] = obstacleGrid[0][i] == 1 ? 0 : (dp[i-1] == 1 ? 1 : 0); 
//        }
//        for (int i = 1; i< m; i++){
//        	dp[0] = obstacleGrid[i][0] == 1 ? 0 : (dp[0] == 1 ? 1 : 0);
//        	for (int j = 1; j < n; j++){
//        		dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j-1];
//        	}
//        }
//        
//        return dp [n-1];
//    }
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
		int []dp = new int [obstacleGrid[0].length];
		dp[0] =1;
		for (int i = 0; i < obstacleGrid.length; i++){
			for (int j = 0; j < obstacleGrid[0].length; j++){
				if (obstacleGrid[i][j] == 1){
					dp[j] = 0;
				}else{
					if (j > 0)
					dp[j] += dp[j-1];
				}
			}//for
		}//for
		return dp[obstacleGrid[0].length -1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] obstacleGrid = {{0,0,0},{0,1,0}, {0,0,0}};
		_63UniquePathsII A =new _63UniquePathsII();
		System.out.println(A.uniquePathsWithObstacles(obstacleGrid));
	}

}

//question:
	//Follow up for "Unique Paths":
	//
	//Now consider if some obstacles are added to the grids. How many unique paths would there be?
	//
	//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	//
	//For example,
	//There is one obstacle in the middle of a 3x3 grid as illustrated below.
	//
	//[
	//  [0,0,0],
	//  [0,1,0],
	//  [0,0,0]
	//]
	//The total number of unique paths is 2.
	//
	//Note: m and n will be at most 100.