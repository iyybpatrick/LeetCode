import java.util.*;

public class _337HouseRobberIII {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	// DP method with O(n) space.
//	 public int rob(TreeNode root) {
//	        if (root == null) return 0;
//	        return CalRob(root, new HashMap<>());
//	    }
//	
//	private int CalRob(TreeNode root, HashMap<TreeNode,Integer> map) {
//		// TODO Auto-generated method stub
//		if (root == null) return 0;
//		if (map.containsKey(root)) return map.get(root);
//		int val = 0;
//		if (root.left != null){
//			val = val + CalRob(root.left.left, map) + CalRob(root.left.right, map);
//		}
//		if (root.right != null){
//			val = val + CalRob(root.right.left, map) + CalRob(root.right.right, map);
//		}
//		return Math.max(val + root.val, CalRob(root.left, map) + CalRob(root.right, map));
//	}
	
	
	 public int rob(TreeNode root) {
	        if (root == null) return 0;
	        int []res = CalRob(root);
	        return Math.max(res[0], res[1]);
	    }

	private int[] CalRob(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return new int[2];
		int[] left = CalRob(root.left);
		int[] right = CalRob(root.right);
		int []res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		root.left = node1; root.right = node2;
		node1.right = node3; node2.right =node4;
		
//		TreeNode root = new TreeNode(4);
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		root.left = node1; node1.left = node2; node2.left = node3;
//		
		_337HouseRobberIII A = new _337HouseRobberIII();
		System.out.println(A.rob(root));
	}

}

//question:
	//The thief has found himself a new place for his thievery again. 
	//There is only one entrance to this area, called the "root." 
	//Besides the root, each house has one and only one parent house. 
	//After a tour, the smart thief realized that "all houses in this place forms a binary tree".
	//It will automatically contact the police if two directly-linked houses were broken into on the same night.
	//
	//Determine the maximum amount of money the thief can rob tonight without alerting the police.
	//
	//Example 1:
	//     3
	//    / \
	//   2   3
	//    \   \ 
	//     3   1
	//Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	//Example 2:
	//     3
	//    / \
	//   4   5
	//  / \   \ 
	// 1   3   1
	//Maximum amount of money the thief can rob = 4 + 5 = 9.