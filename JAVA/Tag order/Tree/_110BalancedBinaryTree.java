import java.util.*;

import java.util.*;

public class _110BalancedBinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs( cal_depth(root.left)- cal_depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }
	public int cal_depth (TreeNode root){
		if (root == null) return 0;
		return ( Math.max(cal_depth(root.left), cal_depth(root.right))+1 );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_110BalancedBinaryTree A= new _110BalancedBinaryTree();
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (4);
		node1.left=node2; //node2.left=node3;
		System.out.println(A.isBalanced(node1));
	}

}

//question:
	//Given a binary tree, determine if it is height-balanced.
	//
	//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	//
