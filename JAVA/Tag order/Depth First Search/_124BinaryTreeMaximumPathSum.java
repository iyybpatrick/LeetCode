

public class _124BinaryTreeMaximumPathSum {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private class ResultType {
		private int singlePath;
		private int maxPath;
		ResultType(int singlePath, int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	public int maxPathSum(TreeNode root) {
		ResultType result = CalResult(root);
		return result.maxPath;
	}
	private ResultType CalResult(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return new ResultType(0, Integer.MIN_VALUE);
		ResultType left = CalResult(root.left);
		ResultType right = CalResult(root.right);
		
		int singlepath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlepath = Math.max(singlepath, 0);
		
		int maxpath = Math.max(left.maxPath, right.maxPath);
		maxpath = Math.max(maxpath, left.singlePath + right.singlePath + root.val);
		
		return new ResultType (singlepath, maxpath);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		root.left = node1; root.right = node2;
		_124BinaryTreeMaximumPathSum A = new _124BinaryTreeMaximumPathSum();
		System.out.println( A.maxPathSum(root));
	}

}

//question;
	//Given a binary tree, find the maximum path sum.
	//
	//For this problem, a path is defined as any sequence of nodes from 
	//some starting node to any node in the tree along the parent-child connections. 
	//The path must contain at least one node and does not need to go through the root.
	//
	//For example:
	//Given the below binary tree,
	//
	//       1
	//      / \
	//     2   3