import java.util.*;
public class _77Combinations {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if ( n <= 0 || n < k) return res;
        List<Integer> path = new LinkedList<>();
        DFS(n, k, 1, res, path);
        return res;
    }
	private void DFS(int n, int k, int start, List<List<Integer>> res, List<Integer> path) {
		// TODO Auto-generated method stub
		if (k == 0){
			res.add(new LinkedList<Integer>(path));
			return;
		}
		for (int i = start; i <= n; i++){
			path.add(i);
			DFS(n, k - 1, i + 1, res, path);
			path.remove(path.size() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_77Combinations A =new _77Combinations();
		List<List<Integer>> res = A.combine(4, 2);
		System.out.println(res);
	}

}

//question:
	//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	//
	//For example,
	//If n = 4 and k = 2, a solution is:
	//
	//[
	//  [2,4],
	//  [3,4],
	//  [2,3],
	//  [1,2],
	//  [1,3],
	//  [1,4],
	//]