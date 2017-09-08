/**
 * Created by YuebinYang on 2017/9/5.
 */
public class _414ThirdMaximumNumber {

    //public int thirdMax(int[] nums) {
    //    if (nums == null ||nums.length == 0) return 0;
    //
    //    if (nums.length == 1) return nums[0];
    //
    //    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    //
    //    int biggest = Integer.MIN_VALUE;
    //    int secondBig = Integer.MIN_VALUE;
    //    int thirdBig = Integer.MIN_VALUE;
    //
    //    for (int i = 0; i < nums.length; i++) {
    //        if (nums[i] == biggest || nums[i] == secondBig || nums[i] == thirdBig) continue;
    //        if (nums[i] >= biggest) {
    //            thirdBig = secondBig;
    //            secondBig = biggest;
    //            biggest = nums[i];
    //        } else if (nums[i] >= secondBig) {
    //            thirdBig = secondBig;
    //            secondBig = nums[i];
    //        } else if (nums[i] >= thirdBig) {
    //            thirdBig = nums[i];
    //        }
    //    } // for
    //
    //    if (thirdBig != Integer.MIN_VALUE) {
    //        return thirdBig;
    //    }
    //    return Math.max(biggest, secondBig);
    //}

    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }


    public static void main(String[] args){
        int[] nums=  {2,2,3,1};
        _414ThirdMaximumNumber A =new _414ThirdMaximumNumber();
        System.out.println(A.thirdMax(nums));
    }
}
