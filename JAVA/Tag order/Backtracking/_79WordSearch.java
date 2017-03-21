
public class _79WordSearch {

	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++){
        	for (int j = 0; j < col; j++){
        		if (DFS(board, i, j, row, col, word, 0)) return true;
        	}//for
        }
        return false;
    }
	private boolean DFS(char[][] board, int i, int j, int maxr, int maxc, String word, int idx) {
		// TODO Auto-generated method stub
		if (idx == word.length()){
			return true;
		}
		if (i < 0 || j < 0 || i >= maxr || j >= maxc) return false;
		if (board[i][j] == word.charAt(idx)){
			board[i][j] ^= 256;
			boolean judge = 
					DFS(board, i - 1, j, maxr, maxc, word, idx + 1) 
					||DFS(board, i + 1, j, maxr, maxc, word, idx + 1)
					||DFS(board, i, j + 1, maxr, maxc, word, idx + 1)
					||DFS(board, i, j - 1, maxr, maxc, word, idx + 1);
			board[i][j] ^= 256;
			return judge;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_79WordSearch  A =new _79WordSearch ();
		char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(A.exist(board, word));
	}

}

//question:
	//Given a 2D board and a word, find if the word exists in the grid.
	//
	//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
	//
	//For example,
	//Given board =
	//
	//[
	//  ['A','B','C','E'],
	//  ['S','F','C','S'],
	//  ['A','D','E','E']
	//]
	//word = "ABCCED", -> returns true,
	//word = "SEE", -> returns true,
	//word = "ABCB", -> returns false.
