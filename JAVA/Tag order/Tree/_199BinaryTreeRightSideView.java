import java.util.*;

import java.util.*;

public class _199BinaryTreeRightSideView {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        view_right (root, result, 0);
        return result;
    }
	private void view_right(TreeNode cur, List<Integer> result, int height) {
		// TODO Auto-generated method stub
		if (cur == null) return ;
		if (result.size() == height){
			result.add(cur.val);
		}
		
		view_right (cur.right, result, height + 1);
		view_right (cur.left, result, height + 1);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =new TreeNode (7);
		TreeNode node1 = new TreeNode (4);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (3);
		TreeNode node4 = new TreeNode (10);
		TreeNode node5 = new TreeNode (9);
		TreeNode node6 = new TreeNode (14);
		root.left = node1; root.right = node4;
		node1.left = node2; node2.right = node3;
		node4.left = node5; node4.right = node6; 
		_199BinaryTreeRightSideView A = new _199BinaryTreeRightSideView();
		List<Integer> result = A.rightSideView(root);
		System.out.println(result);
	}

}

//question:
	//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
	//
	//For example:
	//Given the following binary tree,
	//   1            <---
	// /   \
	//2     3         <---
	// \     \
	//  5     4       <---
	//You should return [1, 3, 4].