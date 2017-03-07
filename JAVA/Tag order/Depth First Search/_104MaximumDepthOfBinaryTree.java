

public class _104MaximumDepthOfBinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		root.left = node1; root.right = node3;
		node1.left = node2; node2.right = node4;// node3.right = node4;
		_104MaximumDepthOfBinaryTree A = new _104MaximumDepthOfBinaryTree();
		System.out.println(A.maxDepth(root));
	}

}

//question:
	//Given a binary tree, find its maximum depth.
	//
	//The maximum depth is the number of nodes
	//along the longest path from the root node down to the farthest leaf node.