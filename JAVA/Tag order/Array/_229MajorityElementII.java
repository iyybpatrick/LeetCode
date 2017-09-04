/**
 * Created by YuebinYang on 2017/9/2.
 */
import java.util.*;
public class _229MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 ) return result;

        int cnt1 = 0, cnt2 = 0, candidate1 = 0, candidate2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                cnt1++;
            } else if (nums[i] == candidate2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1 = 1;
                candidate1 = nums[i];
            } else if (cnt2 == 0) {
                cnt2 = 1;
                candidate2 = nums[i];
            } else {
                cnt1 -= 1;
                cnt2 -= 1;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1)
                cnt1++;
            else if (nums[i] == candidate2)
                cnt2++;
        }
        if (cnt1 > nums.length/3)
            result.add(candidate1);
        if (cnt2 > nums.length/3)
            result.add(candidate2);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        Map<Integer,Integer> map =new HashMap<>();
        if (!set.add(3)) {
            System.out.println(1);
        }
    }

}
