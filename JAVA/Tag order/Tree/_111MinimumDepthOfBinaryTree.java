import java.util.*;

public class _111MinimumDepthOfBinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int minDepth(TreeNode root) {
       if (root == null ) return 0;
       if (root.left == null) return minDepth(root.right) + 1;
       if (root.right == null) return minDepth(root.left) + 1;
       return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (4);
		node1.left=node2; node1.right=node3;
		_111MinimumDepthOfBinaryTree A=new _111MinimumDepthOfBinaryTree();
		System.out.print(A.minDepth(node1));
	}

}
