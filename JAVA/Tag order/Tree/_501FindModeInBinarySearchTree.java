import java.util.*;

public class _501FindModeInBinarySearchTree {
	private int curCount = 0;
	private int curVal = 0;
	private int maxCount = 0;
	private int number = 0;
	private int res[];
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int[] findMode(TreeNode root) {
		traverse_InOrder (root);
		res = new int [number];
		curCount = 0;
		number = 0;
		traverse_InOrder (root);
		return res;
    }
	
	private void traverse_InOrder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return ;
		traverse_InOrder (root.left);
		CountMode (root.val);
		traverse_InOrder (root.right);
		
	}

	private void CountMode(int val) {
		// TODO Auto-generated method stub
		if (val != curVal){
			curVal = val;
			curCount = 0;
		}
			curCount++;
		if (curCount > maxCount){
			maxCount = curCount;
			number = 1;
		}else if (curCount == maxCount){
			if (res != null){
				res[number] = val;
			}
			number ++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(8);
		root.left = node1;
		node1.left = node2;node2.right = node3;
		root.right = node4; node4.right = node5;node5.right = node6;
		_501FindModeInBinarySearchTree A = new _501FindModeInBinarySearchTree();
		int result[]= A.findMode(root);
		for (int i : result){
			System.out.print(i +" ");
		}
	}

}

//question
	//Given a binary search tree (BST) with duplicates, 
	//find all the mode(s) (the most frequently occurred element) in the given BST.
	//
	//Assume a BST is defined as follows:
	//
	//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
	//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
	//Both the left and right subtrees must also be binary search trees.
	//For example:
	//Given BST [1,null,2,2],
	//   1
	//    \
	//     2
	//    /
	//   2
	//return [2].