
public class _213HouseRobberII {

	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(CalRob(nums, 0, nums.length -1), CalRob(nums, 1, nums.length));
    }
	private int CalRob(int[] nums, int lo, int hi) {
		// TODO Auto-generated method stub
		int notrob = 0;
		int rob = 0;
		for (int i = lo; i < hi; i++){
			int currob = notrob + nums[i];
			notrob = Math.max(notrob, rob);
			rob = currob;
		}
		return Math.max(notrob, rob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_213HouseRobberII A =new _213HouseRobberII();
		int []nums = {1,1,1,1};
		System.out.println(A.rob(nums));
	}

}

//question:
	//Note: This is an extension of House Robber.
	//
	//After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
	//
	//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

