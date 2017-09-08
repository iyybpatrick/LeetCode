/**
 * Created by YuebinYang on 2017/9/4.
 */
import java.util.*;
public class _381InsertDeleteGetRandomO1_Duplicates_Allowed {


    Map<Integer, Set<Integer>> map;
    List<Integer> nums;
    Random rand = new Random();
    /** Initialize your data structure here. */
    //public RandomizedCollection() {
    //    map = new HashMap<Integer, Set<Integer>>();
    //    nums = new ArrayList<>();
    //}

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) return false;
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        if (idx < nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(idx, lastVal);
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(idx);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
