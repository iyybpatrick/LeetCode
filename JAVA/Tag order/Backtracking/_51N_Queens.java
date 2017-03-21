import java.util.*;
public class _51N_Queens {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++){
        	for (int j = 0; j < board[0].length; j++){
        		board[i][j] = '.';
        	}
        }
        DFS(res, board, 0);
        return res;
        
    }
	private void DFS(List<List<String>> res, char[][] board, int colStart) {
		// TODO Auto-generated method stub
		if (colStart == board.length){
			List<String> temp = construct(board);
			res.add(temp);
			return;
		}
		for (int i = 0; i < board.length; i++){
			if (isValid(board, i, colStart)){
				board[i][colStart] = 'Q';
				DFS(res, board, colStart + 1);
				board[i][colStart] = '.';
			}
		}//for
			
	}
	private boolean isValid(char[][] board, int row, int col) {
		// TODO Auto-generated method stub
		for (int i =0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if (board[i][j] == 'Q'){
					if (row - col == i - j || row + col == i + j || row == i) return false;
				}
			}
		}
		return true;
	}
	private List<String> construct(char[][] board) {
		// TODO Auto-generated method stub
		List<String> res =new ArrayList<>();
		for (char[] row : board){
			StringBuilder temp = new StringBuilder();
			for ( char c : row){
				temp.append(c);
			}
			res.add(temp.toString());
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_51N_Queens A =new _51N_Queens();
		List<List<String>> res = A.solveNQueens(4);
		System.out.println(res);
	}

}

//question:
	//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
	//
	//
	//
	//Given an integer n, return all distinct solutions to the n-queens puzzle.
	//
	//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
	//
	//For example,
	//There exist two distinct solutions to the 4-queens puzzle:
	//
	//[
	// [".Q..",  // Solution 1
	//  "...Q",
	//  "Q...",
	//  "..Q."],
	//
	// ["..Q.",  // Solution 2
	//  "Q...",
	//  "...Q",
	//  ".Q.."]
	//]