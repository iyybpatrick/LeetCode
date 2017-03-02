
public class _124BinaryTreeMaximumPathSum {

	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private class ResultData {
		private int single_path, max_path;
		ResultData (int single_path, int max_path){
			this.single_path = single_path;
			this.max_path = max_path;
		}
	}
	private ResultData helper (TreeNode root){
		if (root == null) return new ResultData (0,Integer.MIN_VALUE);
		
		ResultData left = helper (root.left);
		ResultData right = helper (root.right);
		
		ResultData result= new ResultData(0, 0);
		result.single_path = Integer.max (left.single_path, right.single_path) + root.val;
		result.single_path = Integer.max(result.single_path, 0);
		
		int max_path = Integer.max(left.max_path, right.max_path);
		result.max_path = Integer.max(max_path, left.single_path + right.single_path + root.val);
		
		return result;
		
	}
	public int maxPathSum(TreeNode root) {
			if (root == null) return 0;
			ResultData result = helper (root);
			return result.max_path;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_124BinaryTreeMaximumPathSum  A = new _124BinaryTreeMaximumPathSum ();
		TreeNode root = new TreeNode(7);
		TreeNode node1 = new TreeNode (5);
		TreeNode node2 = new TreeNode (12);
		root.left = node1; root.right = node2;
		System.out.println(A.maxPathSum(root));
	}

}

//question:
	//Given a binary tree, find the maximum path sum.
	//
	//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
	//
	//For example:
	//Given the below binary tree,
	//
	//       1
	//      / \
	//     2   3
	//Return 6.