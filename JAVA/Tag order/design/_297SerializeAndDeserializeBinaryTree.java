package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class _297SerializeAndDeserializeBinaryTree {

    private int strCnt = 0;

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        serializeHelper(root, str);
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return;
        }
        str.append(root.val).append(",");
        serializeHelper(root.left, str);
        serializeHelper(root.right, str);

        return;
    }

    public TreeNode deserialize(String data) {
        String clean = data.substring(1, data.length() - 1);
        String[] nodes = clean.split(",");
        return deserializeHelper(nodes);
    }
    public TreeNode deserializeHelper(String[] nodes) {
        if (nodes[strCnt].equals("null") || strCnt == nodes.length) {
            strCnt++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[strCnt++]));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    public static void main(String[] args){

        _297SerializeAndDeserializeBinaryTree A = new _297SerializeAndDeserializeBinaryTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        String serial = A.serialize(node1);
        TreeNode root = A.deserialize(serial);
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> iter = set.iterator();

        PriorityQueue<Integer> queue = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Random rand = new Random();
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println(queue.size());

    }

}
