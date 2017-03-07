
public class _110BalancedBinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isBalanced(TreeNode root) {
		return JudgeBalance(root) == -1 ? false : true;
	}
	private int JudgeBalance(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return 0;
		int left = JudgeBalance(root.left);
		int right = JudgeBalance(root.right);
		if (left == -1 || right == -1 || Math.abs(right - left) >1){
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
//		root.left = node1; root.right = node3;
//		node1.left = node2; node3.right = node4;
		root.right = node1; node1.right = node2;
		_110BalancedBinaryTree A = new _110BalancedBinaryTree();
		System.out.println(A.isBalanced(root));
	}

}

//question:
	//Given a binary tree, determine if it is height-balanced.
	//
	//For this problem, a height-balanced binary tree is defined as a binary tree 
	//in which the depth of the two subtrees of every node never differ by more than 1.