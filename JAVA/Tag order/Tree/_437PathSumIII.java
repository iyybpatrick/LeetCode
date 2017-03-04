import java.util.*;

public class _437PathSumIII {
	private int path_num = 0;
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		if (root != null){
			path_traverse (root, 0, sum, map);
		}
		return path_num;
    }
	
	private void path_traverse(TreeNode root, int cur_sum, int target, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		cur_sum += root.val;
		if (map.containsKey(cur_sum - target)){
			path_num += map.get(cur_sum - target);
		}
		map.put(cur_sum, map.getOrDefault(cur_sum, 0) + 1);
		
		if (root.left != null)  path_traverse (root.left, cur_sum, target, map);
		if (root.right != null) path_traverse (root.right, cur_sum, target, map);
		
		map.put(cur_sum, map.get(cur_sum) - 1);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =new TreeNode (7);
		TreeNode node1 = new TreeNode (3);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (5);
		TreeNode node4 = new TreeNode (10);
		TreeNode node5 = new TreeNode (9);
		TreeNode node6 = new TreeNode (14);
		root.left = node1; root.right = node4;
		node1.left = node2; node2.right = node3;
		node4.left = node5; node4.right = node6;	
		_437PathSumIII A =new _437PathSumIII();
		System.out.println(A.pathSum(root, 10));
	}

}

//question:
	//You are given a binary tree in which each node contains an integer value.
	//
	//Find the number of paths that sum to a given value.
	//
	//The path does not need to start or end at the root or a leaf, 
	//but it must go downwards (traveling only from parent nodes to child nodes).
	//
	//The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	//
	//Example:
	//
	//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
	//
	//      10
	//     /  \
	//    5   -3
	//   / \    \
	//  3   2   11
	// / \   \
	//3  -2   1
	//
	//Return 3. The paths that sum to 8 are:
	//
	//1.  5 -> 3
	//2.  5 -> 2 -> 1
	//3. -3 -> 11