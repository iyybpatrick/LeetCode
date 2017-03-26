/**
 * Created by YuebinYang on 2017/3/25.
 */

public class _130SurroundedRegions {

    // DFS method
    //public void solve(char[][] board) {
    //    if (board == null || board.length < 2 || board[0].length < 2) return ;
    //
    //    for (int i = 0; i < board.length; i++){
    //        if (board[i][0] == 'O')
    //            DFS(board, i, 0);
    //        if (board[i][board[0].length - 1] == 'O')
    //            DFS(board, i, board[0].length - 1);
    //    }
    //
    //    for (int j = 0; j < board[0].length; j++){
    //        if (board[0][j] == 'O')
    //            DFS(board, 0, j);
    //        if (board[board.length - 1][j] == 'O')
    //            DFS(board, board.length - 1, j);
    //    }
    //
    //    for (int i = 0; i < board.length; i++){
    //        for (int j = 0; j < board[0].length; j++){
    //            if (board[i][j] == '*') {
    //                board[i][j] = 'O';
    //            }else if (board[i][j] == 'O'){
    //                board[i][j] = 'X';
    //            }
    //
    //        }//for j
    //    }//for i
    //}
    //
    //private void DFS(char[][] board, int i, int j) {
    //    board[i][j] = '*';
    //    if (i > 1 && board[i - 1][j] == 'O')
    //        DFS(board, i - 1, j);
    //    if (j > 1 && board[i][j - 1] == 'O')
    //        DFS(board, i, j - 1);
    //    if (i < (board.length - 2) && board[i + 1][j] == 'O')
    //        DFS(board, i + 1, j);
    //    if (j < (board[0].length - 2) && board[i][j + 1] == 'O')
    //        DFS(board, i, j + 1);
    //}

    public void solve(char[][] board) {

    }


    public static void main (String[] args){
        _130SurroundedRegions A =new _130SurroundedRegions();
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
//        A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//        For example,
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        After running your function, the board should be:
//
//        X X X X
//        X X X X
//        X X X X
//        X O X X
