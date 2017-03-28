/**
 * Created by YuebinYang on 2017/3/27.
 */
public class _45JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1 ) return 0;

        for (int start = 0, step = 1; ; step++){
            if (nums[start] + start >= nums.length - 1){
                return step;
            }

            int maxJump = 0;
            int nextStart = start;
            for (int i = 1; i <= nums[start]; i++){
                if (i + nums[start + i] > maxJump){
                    maxJump = i + nums[start + i];
                    nextStart = start + i;
                }
            }//for i
            start = nextStart;
        }//for start
    }
    
    public static void main(String[] args){
        _45JumpGameII A =new _45JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(A.jump(nums));
    }
}

//question:
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        For example:
//        Given array A = [2,3,1,1,4]
//
//        The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//
