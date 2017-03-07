
public class _100SameTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);
		if (left == true && right == true && p.val == q.val) return true;
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(7);
		root.left = node1; root.right = node3;
		node1.left = node2; node3.left = node4;
		
		TreeNode root1 = new TreeNode(5);
		TreeNode node11 = new TreeNode(6);
		TreeNode node22 = new TreeNode(2);
		TreeNode node33 = new TreeNode(8);
		TreeNode node44 = new TreeNode(7);
		TreeNode node55 = new TreeNode(10);
		root.left = node11; root.right = node33;
		node11.left = node22; node33.left = node44;
		node33.right = node55;
		_100SameTree  A = new _100SameTree ();
		System.out.println(A.isSameTree(root, root1));
	}

}

//question:
	//Given two binary trees, write a function to check if they are equal or not.
	//
	//Two binary trees are considered equal if they are structurally identical
	//and the nodes have the same value.

