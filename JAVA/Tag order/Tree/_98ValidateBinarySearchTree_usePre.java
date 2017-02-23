import java.util.*;


public class _98ValidateBinarySearchTree_usePre {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public boolean isValidBST(TreeNode root) {
		if (root==null) return true;
		
      Stack<TreeNode> stack=new Stack<TreeNode>();
      TreeNode current=root, pre=null;
      while ( current!=null || !stack.isEmpty()){
			// push it's left child.
			while (current!=null){
				stack.push(current);
				current=current.left;
			}//while
			
			current=stack.pop();
			if (pre !=null && pre.val >= current.val){
				return false;
			}//if
			else {
			pre=current;
			current=current.right;
			}//else
		}//while
      return true;
  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_98ValidateBinarySearchTree_usePre A=new _98ValidateBinarySearchTree_usePre();
		TreeNode node1=new TreeNode (-2147483648);
		TreeNode node2=new TreeNode (2147483647);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (8);
		node1.right=node2;
//		node1.left=node2; node1.right=node3; node3.left=node4;
		System.out.print(Integer.MAX_VALUE);
		System.out.print(A.isValidBST(node1));
	}

}

//question：
	//Given a binary tree, determine if it is a valid binary search tree (BST).
	//
	//Assume a BST is defined as follows:
	//
	//The left subtree of a node contains only nodes with keys less than the node's key.
	//The right subtree of a node contains only nodes with keys greater than the node's key.
	//Both the left and right subtrees must also be binary search trees.
	//Example 1:
	//    2
	//   / \
	//  1   3
	//Binary tree [2,1,3], return true.
	//Example 2:
	//    1
	//   / \
	//  2   3
	//Binary tree [1,2,3], return false.