
public class _198HouseRobber {

//	public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        // robInformation[i][0] means do not rob current house, [i][1] means rob it.
//        int [][]robInfo = new int[nums.length + 1][2];
//        for (int i = 1; i <= nums.length; i++){
//        	robInfo[i][0] = Math.max(robInfo[i-1][0], robInfo[i-1][1]);
//        	robInfo[i][1] = robInfo[i-1][0] + nums[i - 1];
//        }
//        return Math.max(robInfo[nums.length][0], robInfo[nums.length][1]);
//    }
	
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0 ) return 0;
		int notrob = 0;
		int rob = 0;
		for (int i = 0; i < nums.length; i++){
			int currob = nums[i] + notrob;
			notrob = Math.max(rob, notrob);
			rob = currob;
		}
		return Math.max(rob, notrob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_198HouseRobber A = new _198HouseRobber();
		int []nums = {1,3,4,5,7,8,10};
		System.out.println(A.rob(nums));
	}

}

//question:
	//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	//
	//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.