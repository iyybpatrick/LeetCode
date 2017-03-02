import java.util.*;

import java.util.*;

public class _144BinaryTreePreorderTraversal {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack <TreeNode> stack =new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	result.add(cur.val);
        	if (cur.right != null) stack.push(cur.right);
        	if (cur.left != null) stack.push(cur.left);
        }//while
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_144BinaryTreePreorderTraversal A=new _144BinaryTreePreorderTraversal();
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
		List<Integer> result = A.preorderTraversal(root);
		System.out.println(result);
		
	}

}

//question:
	//Given a binary tree, return the preorder traversal of its nodes' values.
	//
	//For example:
	//Given binary tree {1,#,2,3},
	//   1
	//    \
	//     2
	//    /
	//   3
	//return [1,2,3].
