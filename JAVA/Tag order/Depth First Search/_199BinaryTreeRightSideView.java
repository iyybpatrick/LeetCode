import java.util.*;

public class _199BinaryTreeRightSideView {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		ViewRight(root, res, 0);
		return res;
		
	}
	private void ViewRight(TreeNode root, List<Integer> res, int level) {
		// TODO Auto-generated method stub
		if (root == null) return;
		if (res.size() == level){
			res.add(root.val);
		}
		ViewRight(root.right, res, level +1);
		ViewRight(root.left, res, level +1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(2);
		root.left = node1; root.right = node2;
		node1.left = node3;
		_199BinaryTreeRightSideView A = new _199BinaryTreeRightSideView();
		List<Integer> res = A.rightSideView(root);
		System.out.println(res);
	}

}

//question:
	//Given a binary tree, imagine yourself standing on the right side of it,
	//return the values of the nodes you can see ordered from top to bottom.
	//
	//For example:
	//Given the following binary tree,
	//   1            <---
	// /   \
	//2     3         <---
	// \     \
	//  5     4       <---
	//You should return [1, 3, 4].

