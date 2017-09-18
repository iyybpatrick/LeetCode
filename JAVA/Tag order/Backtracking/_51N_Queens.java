/**
 * Created by YuebinYang on 9/18/17.
 */
import java.util.*;
public class _51N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        char[][] board= new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        DFS(board, result, 0);
        return result;
    }

    public void DFS(char[][] board, List<List<String>> result, int rowIdx) {
        if (rowIdx == board.length) {
            result.add(construct(board));
            return;
        }

        for (int colIdx = 0; colIdx < board.length; colIdx++) {
            if (valid(board, rowIdx, colIdx)) {
                board[rowIdx][colIdx] = 'Q';
                DFS(board, result, rowIdx + 1);
                board[rowIdx][colIdx] = '.';
            }
        }
    }

    public boolean valid(char[][]board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <board.length; j++) {
                if (board[i][j] == 'Q' && (j == y || y + i == j + x || x + y == i + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> construct(char[][]board) {
        List<String> strList = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            strList.add(new String(board[i]));
        }
        return strList;
    }

}
