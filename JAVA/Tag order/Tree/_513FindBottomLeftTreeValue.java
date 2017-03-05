
import java.util.*;
public class _513FindBottomLeftTreeValue {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int findBottomLeftValue(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        int size = 0;
	        int last = 0;
	        TreeNode cur;
	        while (!queue.isEmpty()){
	        	size =queue.size();
	        	for (int i = 0; i < size; i++){
	        		cur = queue.poll();
	        		if (i == 0) {
	        			last = cur.val;
	        		}//if
	        		if (cur.left != null) queue.offer(cur.left);
	        		if (cur.right != null) queue.offer(cur.right);
	        	}//for
	        }//while
	        return last;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode (5);
		TreeNode node1 = new TreeNode (6);
		TreeNode node2 = new TreeNode (5);
		TreeNode node3 = new TreeNode (4);
		TreeNode node4 = new TreeNode (7);
		TreeNode node5 = new TreeNode (6);
		TreeNode node6 = new TreeNode (8);
		root.left = node1;
		root.right = node2; node1.right = node3; node3.right =node4;
		node2.left = node5; node5.right = node6;
		_513FindBottomLeftTreeValue A =new _513FindBottomLeftTreeValue ();
		System.out.println(A.findBottomLeftValue(root));
		
	}

}

//question:
	//Given a binary tree, find the leftmost value in the last row of the tree.
	//
	//Example 1:
	//Input:
	//
	//    2
	//   / \
	//  1   3
	//
	//Output:
	//1
	//Example 2: 
	//Input:
	//
	//        1
	//       / \
	//      2   3
	//     /   / \
	//    4   5   6
	//       /
	//      7
	//
	//Output:
	//7
	//Note: You may assume the tree (i.e., the given root node) is not NULL.