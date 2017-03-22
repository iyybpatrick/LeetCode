import java.util.*;
public class _216CombinationSumIII {

	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> path = new ArrayList<>();
	        DFS(res, path, k, n, 0, 1);
	        return res;
	    }
	private void DFS(List<List<Integer>> res, List<Integer> path, int k, int n, int sum, int start) {
		// TODO Auto-generated method stub
		if (k == 0 && sum == n){
			res.add(new ArrayList<>(path));
			return;
		}
		if ( k == 0) return;
		for (int i = start; i <= 9; i++){
			if (sum + i > n) break;
			path.add(i);
			DFS(res, path, k - 1, n, sum + i, i + 1);
			path.remove(path.size() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_216CombinationSumIII A =new _216CombinationSumIII();
		List<List<Integer>> res = A.combinationSum3(3, 9);
		System.out.println(res);
	}

}

//question:
	//Find all possible combinations of k numbers that add up to a number n,
	//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	//
	//
	//Example 1:
	//
	//Input: k = 3, n = 7
	//
	//Output:
	//
	//[[1,2,4]]
	//
	//Example 2:
	//
	//Input: k = 3, n = 9
	//
	//Output:
	//
	//[[1,2,6], [1,3,5], [2,3,4]]