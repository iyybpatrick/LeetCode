
public class _62UniquePaths {

	 public int uniquePaths(int m, int n) {
		 if(m<=0||n<=0)
			 return -1;
	        int [][]s=new int[m][n];
	        int i,j;
	        for(i=0;i<m;i++) s[i][0]=1;
	        for(j=1;j<n;j++) s[0][j]=1;
	        
	        for(i=1;i<m;i++){
	        	for(j=1;j<n;j++){
	        		s[i][j]=s[i-1][j]+s[i][j-1];
	        	}//for
	        }//for
	        return s[m-1][n-1];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_62UniquePaths A=new _62UniquePaths();
		System.out.print(A.uniquePaths(7, 3));
	}
}

//question:
		//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
		//
		//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
		//
		//How many possible unique paths are there?