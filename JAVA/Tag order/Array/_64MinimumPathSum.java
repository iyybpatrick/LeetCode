
public class _64MinimumPathSum {

	public int minPathSum(int[][] grid) {
		if(grid[0].length==0)
			return 0;
        int []s=new int[grid[0].length];
        int i,j;
        s[0]=grid[0][0];
        for(j=1;j<grid[0].length;j++) {s[j]=grid[0][j]+s[j-1];}
        for(i=1;i<grid.length;i++){
        	s[0]=s[0]+grid[i][0];
        	for(j=1;j<grid[0].length;j++){
        		s[j]=Math.min(s[j], s[j-1])+grid[i][j];
        	}//for
        }//for
        return s[grid[0].length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]grid={{1,5,3,7},{2,6,4,1},{5,4,6,5}};
		int [][]grid1={{}};
		int [][]grid2={{1,3,5},{2,4,8},{3,1,2}};
		_64MinimumPathSum A=new _64MinimumPathSum();
		System.out.println(A.minPathSum(grid2));
	}

}

//question:
	//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	//
	//Note: You can only move either down or right at any point in time.