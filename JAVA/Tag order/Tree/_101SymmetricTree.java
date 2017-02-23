import java.util.*;

import java.util.*;

public class _101SymmetricTree {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return JudgeSymmetric (root.left, root.right);
    }
	public boolean JudgeSymmetric (TreeNode left, TreeNode right){
		if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        
        if (left.val == right.val){
        	return JudgeSymmetric(left.left, right.right) && JudgeSymmetric (left.right, right.left);
        }//if   
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (1);
		TreeNode node4=new TreeNode (4);
		TreeNode node5=new TreeNode (4);
		node1.left=node2; node1.right=node3; node2.left=node4; node3.right=node5;
		_101SymmetricTree A=new _101SymmetricTree();
		System.out.print(A.isSymmetric(node1));
		
	}

}

//question:
	//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	//
	//For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	//
	//    1
	//   / \
	//  2   2
	// / \ / \
	//3  4 4  3
	//But the following [1,2,2,null,3,null,3] is not:
	//    1
	//   / \
	//  2   2
	//   \   \
	//   3    3
	//Note:
	//Bonus points if you could solve it both recursively and iteratively.