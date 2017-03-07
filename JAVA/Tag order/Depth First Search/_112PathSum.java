

public class _112PathSum {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean hasPathSum(TreeNode root, int sum) {
		return JudgeIfHas(root, 0, sum);
	}
	private boolean JudgeIfHas(TreeNode root, int cur, int sum) {
		// TODO Auto-generated method stub
		if (root == null) return false;
		cur += root.val;
		if (root.left == null && root.right == null && cur == sum) return true;
		return JudgeIfHas(root.left, cur, sum) || JudgeIfHas(root.right, cur, sum);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method 
		TreeNode root = new TreeNode(-2);
		TreeNode node1 = new TreeNode(-3);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		root.right = node1; //root.right = node3;
		//node1.left = node2; node3.right = node4;
		_112PathSum  A = new _112PathSum ();
		System.out.println(A.hasPathSum(root, -5));
	}

}

//question:
	//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
	//that adding up all the values along the path equals the given sum.
	//
	//For example:
	//Given the below binary tree and sum = 22,
	//              5
	//             / \
	//            4   8
	//           /   / \
	//          11  13  4
	//         /  \      \
	//        7    2      1
	//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

