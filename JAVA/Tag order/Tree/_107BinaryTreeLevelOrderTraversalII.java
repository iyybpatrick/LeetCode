import java.util.*;
public class _107BinaryTreeLevelOrderTraversalII {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        	result.add(0,temp);   
        }//while
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (4);
		node1.left=node2; node1.right=node3; node3.left=node4;
		_107BinaryTreeLevelOrderTraversalII A=new _107BinaryTreeLevelOrderTraversalII();
		List<List<Integer>> result= A.levelOrderBottom(node1);
		System.out.println(result);
	}

}

//question:
	//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
	//
	//For example:
	//Given binary tree [3,9,20,null,null,15,7],
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	//return its bottom-up level order traversal as:
	//[
	//  [15,7],
	//  [9,20],
	//  [3]
	//]