/**
 * Created by YuebinYang on 2017/9/4.
 */
import java.util.*;
public class _380InsertDeleteGetRandomO1 {


    /** Initialize your data structure here. */
    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        if (idx < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
