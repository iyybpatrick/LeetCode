/**
 * Created by YuebinYang on 9/18/17.
 */
public class _52N_QueensII {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        backtracking(0, col, diag1, diag2);
        return count;
    }

    public void backtracking(int row, boolean[]col, boolean[]diag1, boolean[]diag2) {
        for (int i = 0; i < col.length; i++) {
            if(col[i]) continue;
            int dg1 = row + i;
            int dg2 = i - row + col.length;
            if (diag1[dg1] || diag2[dg2]) continue;
            if (row == col.length - 1) {
                count++;
                return;
            }
            col[i] = diag1[dg1] = diag2[dg2] = true;
            backtracking(row + 1, col, diag1, diag2);
            col[i] = diag1[dg1] = diag2[dg2] = false;
        }
    }

}
