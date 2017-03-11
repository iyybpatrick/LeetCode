import java.util.*;
public class _120Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int len = triangle.size();
        int [][]dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++){
        	for (int j = 0; j < i + 1; j++){
        		if (j == 0) dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
        		else if ( j == i) dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
        		else{
        			dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
        		}
        	}	
        }
      int min = dp[len-1][0];
      for (int i = 1; i < len; i++){
    	  min = min < dp[len-1][i] ? min : dp[len-1][i];
      }
      return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_120Triangle A= new _120Triangle();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		List<List<Integer>> res = new ArrayList<>();
		res.add(l1);
		res.add(l2);
		res.add(l3);
		res.add(l4);
		System.out.println(A.minimumTotal(res));
	}

}

//question:
	//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	//
	//For example, given the following triangle
	//[
	//     [2],
	//    [3,4],
	//   [6,5,7],
	//  [4,1,8,3]
	//]
	//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	//
