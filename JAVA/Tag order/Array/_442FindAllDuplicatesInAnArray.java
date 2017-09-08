/**
 * Created by YuebinYang on 2017/9/5.
 */
import java.util.*;
public class _442FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length <= 1) return result;

        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            } else {
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }
}
