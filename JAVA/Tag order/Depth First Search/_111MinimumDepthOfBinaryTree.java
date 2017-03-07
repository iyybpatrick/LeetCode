

public class _111MinimumDepthOfBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null) return minDepth(root.right) + 1;
		if (root.right == null) return minDepth(root.left) + 1;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return Math.min(left, right) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//Given a binary tree, find its minimum depth.
	//
	//The minimum depth is the number of nodes along the shortest path
	//from the root node down to the nearest leaf node.