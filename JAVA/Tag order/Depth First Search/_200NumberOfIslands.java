
public class _200NumberOfIslands {
	private int n;
	private int m;
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++){
        	for (int j = 0; j < m; j++){
        		if (grid[i][j] == '1'){
        			blankgrid(grid, i, j);
        			count ++;
        		}
        	}//for
        }//for
        return count;
    }
	private void blankgrid(char[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
		grid[i][j] = '0';
		blankgrid(grid, i + 1, j);
		blankgrid(grid, i - 1, j);
		blankgrid(grid, i, j - 1);
		blankgrid(grid, i, j + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		_200NumberOfIslands A = new _200NumberOfIslands();
		System.out.println( A.numIslands(grid));
	}

}

//question;
	//Given a 2d grid map of '1's (land) and '0's (water),
	//count the number of islands. An island is surrounded by water and is formed 
	//by connecting adjacent lands horizontally or vertically. 
	//You may assume all four edges of the grid are all surrounded by water.
	//
	//Example 1:
	//
	//11110
	//11010
	//11000
	//00000
	//Answer: 1
	//
	//Example 2:
	//
	//11000
	//11000
	//00100
	//00011
	//Answer: 3