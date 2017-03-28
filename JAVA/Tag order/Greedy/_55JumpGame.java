/**
 * Created by YuebinYang on 2017/3/27.
 */
public class _55JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 ) return true;

        int max = nums[0];

        for (int i = 1; i < nums.length && max >= i ; i++){
            max = Math.max(max,i + nums[i]);
        }
        if (max >= nums.length - 1) return true;
        return false;

    }

    public static void main(String[] args){
        _55JumpGame A =new _55JumpGame();
        int []nums = {1,0};
        System.out.println(A.canJump(nums));
    }
}

//question:
//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        For example:
//        A = [2,3,1,1,4], return true.
//
//        A = [3,2,1,0,4], return false.