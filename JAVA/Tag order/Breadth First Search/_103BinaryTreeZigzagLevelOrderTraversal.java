
import java.util.*;
public class _103BinaryTreeZigzagLevelOrderTraversal {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>>  res = new LinkedList<>();
		if (root == null) return res;
		Stack <TreeNode> stack1 = new Stack<>();
		Stack <TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		int size = 0;
		TreeNode cur = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()){
			while (!stack1.isEmpty()){
				List<Integer> level = new LinkedList<>();
				size = stack1.size();
				for (int i = 0; i < size; i++){
					cur = stack1.pop();
					level.add(cur.val);
					if (cur.left != null) stack2.push(cur.left);
					if (cur.right != null) stack2.push(cur.right);
				}//for
				if (!level.isEmpty())
				res.add(level);
			}//while
			
			while (!stack2.isEmpty()){
				List<Integer> level = new LinkedList<>();
				size = stack2.size();
				for (int i = 0; i < size; i++){
					cur = stack2.pop();
					level.add(cur.val);
					if (cur.right != null) stack1.push(cur.right);
					if (cur.left != null) stack1.push(cur.left);
				}//for
				if (!level.isEmpty())
				res.add(level);
			}//while
		}//while
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(8);
		TreeNode node6 = new TreeNode(10);
		root.left = node1; root.right = node2;
		node1.left = node3; node1.right = node4;
		node2.left = node5; node2.right = node6;
		_103BinaryTreeZigzagLevelOrderTraversal A = new _103BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> res = A.zigzagLevelOrder(root);
		System.out.println(res);
	}
	

}

//question:
	//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
	//
	//For example:
	//Given binary tree [3,9,20,null,null,15,7],
	//    3
	//   / \
	//  9  20
	//    /  \
	//   15   7
	//return its zigzag level order traversal as:
	//[
	//  [3],
	//  [20,9],
	//  [15,7]
	//]