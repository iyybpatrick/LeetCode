
import java.util.*;
public class _102BinaryTreeLevelOrderTraversal {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new LinkedList <List<Integer>>();
        if (root ==null ) return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
        	int num=queue.size();
        	List<Integer> temp=new LinkedList<Integer>();
        	
        	for(int i=0; i<num; i++){
        		if (queue.peek().left != null) queue.offer(queue.peek().left);
        		if (queue.peek().right != null) queue.offer(queue.peek().right);
        		temp.add(queue.poll().val);
        	}//for
        	result.add(temp);   
        }//while
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_102BinaryTreeLevelOrderTraversal A=new _102BinaryTreeLevelOrderTraversal();
		TreeNode root =new TreeNode(3);
		TreeNode node1 =new TreeNode(9);
		TreeNode node2 =new TreeNode(5);
		TreeNode node3 =new TreeNode(6);
		TreeNode node4 =new TreeNode(7);
		TreeNode node5 =new TreeNode(8);
		TreeNode node6 =new TreeNode(9);
		root.left=node1; node1.left=node2; node2.right=node3; node3.right=node4; root.right=node5; node5.left=node6;
		List<List<Integer>> result= A.levelOrder(root);
		System.out.println(result);
		
		
	}

}

//question:
	//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	//
	//For example:
	//Given binary tree [3,9,20,null,null,15,7],
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	//return its level order traversal as:
	//[
	//  [3],
	//  [9,20],
	//  [15,7]
	//]