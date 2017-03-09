
public class _130SurroundedRegions {

	public void solve(char[][] board) {
     if (board == null) return;
     if (board.length < 2 || board[0].length < 2) return;
     int m = board.length; 
     int n = board[0].length;
     for (int i = 0; i < m; i++){
    	 if (board[i][0] == 'O')
    		 DFS(board, i, 0);
    	 if (board[i][n-1] == 'O')
    		 DFS(board, i, n-1);
     }//for
     
     for (int j = 0; j < n; j++){
    	 if (board[0][j] == 'O')
    		 DFS(board, 0, j);
    	 if (board[m-1][j] == 'O')
    		 DFS(board, m-1, j);
     }//for
     
     for (int i = 0; i < m; i++){
    	 for (int j = 0; j < n; j++){
    		 if (board[i][j] == 'O'){
    			 board[i][j] = 'X';
    		 }else if (board[i][j] == '*'){
    			 board[i][j] = 'O';
    		 }
    	 }
     }
     return;
    }
	private void DFS(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) 
			return;
		
		if (board[i][j] == 'O')
			board[i][j] = '*';
		
		if (i > 1 && board[i-1][j] == 'O')
			DFS(board, i-1, j);
		if (j > 1 && board[i][j-1] == 'O')
			DFS(board, i, j-1);
		if (i < board.length - 2 && board[i+1][j] == 'O')
			DFS(board, i+1, j);
		if (j < board[0].length - 2 && board[i][j+1] == 'O')
			DFS(board, i, j+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_130SurroundedRegions A = new _130SurroundedRegions();
		char [][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		A.solve(board);
		for (char[] row : board){
			for ( char element : row){
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}

}

//question:
	//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
	//
	//A region is captured by flipping all 'O's into 'X's in that surrounded region.
	//
	//For example,
	//X X X X
	//X O O X
	//X X O X
	//X O X X
	//After running your function, the board should be:
	//
	//X X X X
	//X X X X
	//X X X X
	//X O X X
