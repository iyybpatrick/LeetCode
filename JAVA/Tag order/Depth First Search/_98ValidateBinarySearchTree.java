
public class _98ValidateBinarySearchTree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public boolean isValidBST(TreeNode root) {
			return JudgeValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	private boolean JudgeValid(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if (root == null) return true;
		if (root.val >= maxValue || root.val <= minValue) return false;
		
		return JudgeValid(root.left, minValue, root.val) && JudgeValid(root.right, root.val, maxValue);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_98ValidateBinarySearchTree A = new _98ValidateBinarySearchTree();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(7);
		root.left = node1; root.right = node3;
		node1.left = node2; node3.left = node4;
		System.out.println(A.isValidBST(root));
	}

}

//question:
	//Given a binary tree, determine if it is a valid binary search tree (BST).
	//
	//Assume a BST is defined as follows:
	//
	//The left subtree of a node contains only nodes with keys less than the node's key.
	//The right subtree of a node contains only nodes with keys greater than the node's key.
	//Both the left and right subtrees must also be binary search trees.
	//Example 1:
	//    2
	//   / \
	//  1   3
	//Binary tree [2,1,3], return true.
	//Example 2:
	//    1
	//   / \
	//  2   3
	//Binary tree [1,2,3], return false.