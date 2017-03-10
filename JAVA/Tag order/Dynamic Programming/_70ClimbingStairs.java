
public class _70ClimbingStairs {

	public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int []dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
        	dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_70ClimbingStairs A =new _70ClimbingStairs();
		System.out.println(A.climbStairs(3));
	}

}

//question:
	//You are climbing a stair case. It takes n steps to reach to the top.
	//
	//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	//
	//Note: Given n will be a positive integer.