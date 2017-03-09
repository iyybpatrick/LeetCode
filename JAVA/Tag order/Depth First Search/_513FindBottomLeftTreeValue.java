
public class _513FindBottomLeftTreeValue {
	int bottom_val = 0;
	int level = 0;
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int findBottomLeftValue(TreeNode root) {
		DFS(root, 0);
		return bottom_val;
	}
	private void DFS(TreeNode root, int level) {
		// TODO Auto-generated method stub
		if (root == null) return;
		if (this.level == level){
			this.level ++;
			bottom_val = root.val;
		}
		DFS(root.left, level + 1);
		DFS(root.right, level + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		root.right = node1; root.right = node2;
		node1.left = node3; node2.left = node4;node2.right = node5;
		node4.left = node6;
		_513FindBottomLeftTreeValue A = new _513FindBottomLeftTreeValue();
		System.out.println(A.findBottomLeftValue(root));
	}

}

//question:
	//Given a binary tree, find the leftmost value in the last row of the tree.
	//
	//Example 1:
	//Input:
	//
	//    2
	//   / \
	//  1   3
	//
	//Output:
	//1
	//Example 2: 
	//Input:
	//
	//        1
	//       / \
	//      2   3
	//     /   / \
	//    4   5   6
	//       /
	//      7
	//
	//Output:
	//7
	//Note: You may assume the tree (i.e., the given root node) is not NULL.