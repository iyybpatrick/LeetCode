import java.util.*;

public class _104MaximumDepthOfBinaryTree {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return find_depth (root,1);
    }
	public int find_depth (TreeNode root, int cur_depth){
		if (root==null){
			return cur_depth-1;
		}
		if (root.left != null && root.right != null){
			return Math.max(find_depth(root.left, cur_depth+1), find_depth(root.right, cur_depth+1));
		}
		if (root.left !=null){
			return find_depth(root.left, cur_depth+1);
		}
		if (root.right !=null){
			return find_depth(root.right, cur_depth+1);
		}
		return cur_depth;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_104MaximumDepthOfBinaryTree A=new _104MaximumDepthOfBinaryTree();
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (4);
		TreeNode node5=new TreeNode (3);
		TreeNode node6=new TreeNode (1);
		TreeNode node7=new TreeNode (6);
		TreeNode node8=new TreeNode (4);
		node1.left=node2; node1.right=node3; node3.left=node4; node4.right=node5; node2.left=node6; node6.right=node7; node5.right=node8;
		System.out.print(A.maxDepth(node1));
	}

}

//question:
	//Given a binary tree, find its maximum depth.
	//
	//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.