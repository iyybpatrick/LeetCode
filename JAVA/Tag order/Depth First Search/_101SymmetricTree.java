
public class _101SymmetricTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return JudegeSymmetric(root.left, root.right);
	}
	private boolean JudegeSymmetric(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val == right.val){
		return JudegeSymmetric(left.left, right.right) && JudegeSymmetric(left.right, right.left);
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		root.left = node1; root.right = node3;
		node1.left = node2; node3.right = node4;
		_101SymmetricTree A = new _101SymmetricTree();
		System.out.println(A.isSymmetric(root));
	}

}

//question:
	//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	//
	//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	//
	//    1
	//   / \
	//  2   2
	// / \ / \
	//3  4 4  3
	//But the following [1,2,2,null,3,null,3] is not:
	//    1
	//   / \
	//  2   2
	//   \   \
	//   3    3
	//Note:
	//Bonus points if you could solve it both recursively and iteratively.