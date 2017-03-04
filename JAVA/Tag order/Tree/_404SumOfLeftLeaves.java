import java.util.*;

public class _404SumOfLeftLeaves {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
	    if (root == null) return 0;
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    TreeNode cur = null;
	    while (!queue.isEmpty()){
	    	cur = queue.poll();
	    	if (cur.left != null && cur.left.left == null && cur.left.right == null){
	    		sum += cur.left.val;
	    	}
	    	if (cur.left != null){
	    		queue.offer(cur.left);
	    	}
	    	if (cur.right != null){
	    		queue.offer(cur.right);
	    	}
	    }//while
	    return sum;
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
		_404SumOfLeftLeaves A= new _404SumOfLeftLeaves();
		System.out.println(A.sumOfLeftLeaves(root));
	}

}

//question:
	//Find the sum of all left leaves in a given binary tree.
	//
	//Example:
	//
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	//
	//There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
