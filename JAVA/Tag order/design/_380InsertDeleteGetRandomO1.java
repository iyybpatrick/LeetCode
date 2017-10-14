package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
import java.util.*;
public class _380InsertDeleteGetRandomO1 {

    class RandomizedSet {
        class ListNode{
            ListNode next;
            ListNode prev;
            int val;
            ListNode(int val) {
                this.val = val;
            }
        }
        ListNode head;
        ListNode tail;
        Map<Integer, ListNode> map;
        Random rand;
        int count = 0;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
            head.prev = null;
            tail.next = null;
            map = new HashMap<Integer, ListNode>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            ListNode newNode = new ListNode(val);
            map.put(val, newNode);
            head.next.prev = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
            count ++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            ListNode toDelete = map.get(val);
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
            map.remove(val);
            count --;
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int number = rand.nextInt(count);
            ListNode cur = head.next;
            for (int i = 0; i < number; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
