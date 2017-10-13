package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
import java.util.*;
public class _146LRUCache {
    class LRUCache {
        private class Node{
            int key, value;
            Node prev, next;
            Node(int k, int v){
                this.key = k;
                this.value = v;
            }
            Node(){
                this(0, 0);
            }
        }
        private int capacity, count;
        private Map<Integer, Node> map;
        private Node head, tail;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node n = map.get(key);
            if(null==n){
                return -1;
            }
            update(n);
            return n.value;
        }

        public void put(int key, int value) {
            Node n = map.get(key);
            if(null==n){
                n = new Node(key, value);
                map.put(key, n);
                add(n);
                ++count;
            }
            else{
                n.value = value;
                update(n);
            }
            if(count>capacity){
                Node toDel = tail.prev;
                remove(toDel);
                map.remove(toDel.key);
                --count;
            }
        }

        private void update(Node node){
            remove(node);
            add(node);
        }
        private void add(Node node){
            Node after = head.next;
            head.next = node;
            node.prev = head;
            node.next = after;
            after.prev = node;
        }

        private void remove(Node node){
            Node before = node.prev, after = node.next;
            before.next = after;
            after.prev = before;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
