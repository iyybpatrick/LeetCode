
public class _329LongestIncreasingPathInAMatrix {
	private int [][]dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]visited = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++){
        		if (visited[i][j] == 0){
        			int  len = DFS (i, j, m, n, visited, matrix);
        			max = Math.max(max, len);
        		}
        	}
        }//for
        return max;
    }
	private int DFS(int i, int j, int m, int n, int[][] visited, int [][]matrix) {
		// TODO Auto-generated method stub
		if (visited[i][j] != 0) return visited[i][j];
		
		int max = 1;
		for (int []dir : dirs){
			 int x = i + dir[0];
			 int y = j + dir[1];
			 if (x < 0 || y < 0 || x >= m || y >= n ||  matrix[x][y] <= matrix[i][j]) continue;
			 int len = 1 + DFS(x, y, m, n, visited,matrix);
			 max = Math.max(len, max);
		}//for
		visited[i][j] = max;
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_329LongestIncreasingPathInAMatrix  A = new _329LongestIncreasingPathInAMatrix ();
		int [][]nums = {{9,9,4}, {6,6,8},{2,1,1}};
		int [][] matrix = {{3,4,5}, {3,2,6}, {2,2,1}};
		System.out.println(A.longestIncreasingPath(matrix));
	}

}

//question:
	//Given an integer matrix, find the length of the longest increasing path.
	//
	//From each cell, you can either move to four directions: left, right, up or down. 
	//You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
	//
	//Example 1:
	//
	//nums = [
	//  [9,9,4],
	//  [6,6,8],
	//  [2,1,1]
	//]
	//Return 4
	//The longest increasing path is [1, 2, 6, 9].
	//
	//Example 2:
	//
	//nums = [
	//  [3,4,5],
	//  [3,2,6],
	//  [2,2,1]
	//]
	//Return 4
	//The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

