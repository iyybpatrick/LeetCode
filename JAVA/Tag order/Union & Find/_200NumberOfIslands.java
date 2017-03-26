/**
 * Created by YuebinYang on 2017/3/26.
 */
public class _200NumberOfIslands {

    //public int numIslands(char[][] grid) {
    //    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    //    int count = 0;
    //    for (int i = 0; i < grid.length; i++) {
    //        for (int j = 0; j < grid[0].length; j++) {
    //            if (grid[i][j] == '1') {
    //                DFS(grid, i, j);
    //                count++;
    //            }
    //        }//for j
    //    }//for i
    //
    //    return count;
    //}
    //
    //private void DFS(char[][] grid, int i, int j) {
    //    grid[i][j] = '*';
    //    if (i > 0 && grid[i - 1][j] == '1')
    //        DFS(grid, i - 1, j);
    //    if (j > 0 && grid[i][j - 1] == '1')
    //        DFS(grid, i, j - 1);
    //    if (i < (grid.length - 1) && grid[i + 1][j] == '1')
    //        DFS(grid, i + 1, j);
    //    if (j < (grid[0].length - 1) && grid[i][j + 1] == '1')
    //        DFS(grid, i, j + 1);
    //}

    public class UF{
        private int count = 0;
        private int []parent;
        UF(int m ,int n , char[][] grid){
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == '1')
                        count ++;
                }//for j
            }//for i

        parent = new int[m * n];
            for (int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
        }//UF

        int find (int p){
            while (p != parent[p]){
                 parent[p] = parent[parent[p]];
                 p = parent[p];
            }//while
            return p;
        }

        void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            parent[pRoot] = qRoot;
            count --;
        }

    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        UF uf = new UF(grid.length, grid[0].length, grid);
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '0') continue;

                int p = i * grid[0].length + j;
                int q;
                if (i > 0 && grid[i - 1][j] == '1'){
                    q = p - grid[0].length;
                    uf.union(p, q);
                }
                if (i < (grid.length - 1) && grid[i + 1][j] == '1'){
                    q = p + grid[0].length;
                    uf.union(p, q);
                }
                if (j > 0 && grid[i][j - 1] == '1'){
                    q = p - 1;
                    uf.union(p, q);
                }
                if (j < (grid[0].length - 1) && grid[i][j + 1] == '1'){
                    q = p + 1;
                    uf.union(p, q);
                }
            }//for j
        }//for i
        return uf.count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        _200NumberOfIslands A = new _200NumberOfIslands();
        System.out.println(A.numIslands(grid));
    }
}


//question:
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        11110
//        11010
//        11000
//        00000
//        Answer: 1
//
//        Example 2:
//
//        11000
//        11000
//        00100
//        00011
//        Answer: 3