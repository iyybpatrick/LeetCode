import java.util.Arrays;

public class _473MatchsticksToSquare {

	public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums){
        	sum += num;
        }
        Arrays.sort(nums);
        Reverse(nums);
        for ( int num : nums){
        	System.out.print(num +" ");
        }
        if (sum % 4 != 0) return false;
        return DFS (nums, new int [4], 0, sum/4);
    }
	private void Reverse(int[] nums) {
		// TODO Auto-generated method stub
		int i = 0, j = nums.length -1;
		while (i < j){
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	private boolean DFS(int[] nums, int[] sums, int index, int target) {
		// TODO Auto-generated method stub
		if (index == nums.length){
			if (sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target){
				return true;
			}
				return false;
		}//if
		
		for (int i = 0; i < 4; i++){
			if (sums[i] + nums[index] > target) continue;
			sums[i] += nums[index];
			if (DFS(nums, sums, index + 1, target)) return true;
			sums[i] -= nums[index];
		}//for
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,2,3,4,5,6,7,8};
		_473MatchsticksToSquare A =new _473MatchsticksToSquare();
		
		System.out.println(A.makesquare(nums));
	}

}

//question:
	//Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
	//
	//Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
	//
	//Example 1:
	//Input: [1,1,2,2,2]
	//Output: true
	//
	//Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
	//Example 2:
	//Input: [3,3,3,3,4]
	//Output: false
	//
	//Explanation: You cannot find a way to form a square with all the matchsticks.
	//Note:
	//The length sum of the given matchsticks is in the range of 0 to 10^9.
	//The length of the given matchstick array will not exceed 15.