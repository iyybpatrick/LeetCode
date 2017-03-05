
import java.util.*;
public class _508MostFrequentSubtreeSum {
	Map<Integer, Integer> map = new HashMap<>();
	private int max_count = 0;
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int[] findFrequentTreeSum(TreeNode root) {
        FindFrequentSum (root);
        List<Integer> result = new LinkedList<>();
        for (int x : map.keySet()){
        	if (map.get(x) == max_count){
        		result.add(x);
        	}
        }//for
        int res[] = new int [result.size()];
        for (int i=0; i<result.size(); i++){
        	res[i] = result.get(i);
        }
        return res;
    }
	private int FindFrequentSum(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null ) return 0;
		int Sum_left = FindFrequentSum (root.left);
		int Sum_right = FindFrequentSum (root.right);
		int Sum_all = Sum_left +Sum_right + root.val;
		map.put(Sum_all, map.getOrDefault(Sum_all, 0) + 1);
		int count = map.get(Sum_all);
		max_count = Math.max(max_count, count);
		
		return Sum_all;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>(); 
		_508MostFrequentSubtreeSum A = new _508MostFrequentSubtreeSum();
		TreeNode root = new TreeNode (5);
		TreeNode node1 = new TreeNode (2);
		TreeNode node2 = new TreeNode (-3);
		root.left = node1;
		root.right = node2;
		int res[] = A.findFrequentTreeSum(root);
		for (int x: res){
			System.out.println(x +" ");
		}
	}

}

//question:
	//Given the root of a tree, you are asked to find the most frequent subtree sum. 
	//The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
	//
	//Examples 1
	//Input:
	//
	//  5
	// /  \
	//2   -3
	//return [2, -3, 4], since all the values happen only once, return all of them in any order.
	//Examples 2
	//Input:
	//
	//  5
	// /  \
	//2   -5
	//return [2], since 2 happens twice, however -5 only occur once.
	//Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.