
import java.util.*;
public class _515FindLargestValueInEachTreeRow {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result  = new LinkedList<Integer>();
	       if (root == null) return result;
	       Queue <TreeNode> queue = new LinkedList<>();
	       queue.offer(root);
	       int size = 0;
	       TreeNode cur;
	       while (!queue.isEmpty()){
	    	   size = queue.size();
	    	   int max = Integer.MIN_VALUE;
	    	   for (int i= 0; i < size; i++){
	    		   cur = queue.poll();
	    		   if (cur.val > max){
	    			   max = cur.val;
	    		   }//if
	    		   if (cur.left != null) queue.offer(cur.left);
	    		   if (cur.right != null)queue.offer(cur.right);
	    	   }//for
	    	   result.add(max);
	       }//while
	       return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode (5);
		TreeNode node1 = new TreeNode (6);
		TreeNode node2 = new TreeNode (5);
		TreeNode node3 = new TreeNode (4);
		TreeNode node4 = new TreeNode (7);
		TreeNode node5 = new TreeNode (8);
		TreeNode node6 = new TreeNode (8);
		root.left = node1;
		root.right = node2; node1.right = node3; node3.right =node4;
		node2.left = node5; node5.right = node6;
		_515FindLargestValueInEachTreeRow A = new _515FindLargestValueInEachTreeRow();
		
		List<Integer> result =  A.largestValues(root);
		System.out.println(result);
	}

}

//question:
	//You need to find the largest value in each row of a binary tree.
	//
	//Example:
	//Input: 
	//
	//          1
	//         / \
	//        3   2
	//       / \   \  
	//      5   3   9 
	//
	//Output: [1, 3, 9]