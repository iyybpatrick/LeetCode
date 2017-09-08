/**
 * Created by YuebinYang on 2017/9/5.
 */
import java.util.*;
public class _448FindAllNumbersDisappearedInanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length <= 1) return result;

        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }

        for (int i =0 ; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
    public static void test(int m) {
        m = m + 1;
        m = m * m;
        System.out.println("in :" + m);
    }
    public static void main(String[] args){
        int k = 9;
        test(k);
        String a = "hello";

        Map<Integer, Integer> map =new HashMap<>();
        System.out.print(k);
    }

}
