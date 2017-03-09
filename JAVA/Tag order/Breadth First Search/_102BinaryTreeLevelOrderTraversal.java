import java.util.*;
public class _102BinaryTreeLevelOrderTraversal {

	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode cur = null;
		int size = 0;
		while (!queue.isEmpty()){
			size = queue.size();
			List<Integer> cur_level = new LinkedList<>();
			for (int i = 0; i < size; i++){
				cur = queue.poll();
				cur_level.add(cur.val);
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}//for
			res.add(cur_level);
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
		_102BinaryTreeLevelOrderTraversal A = new _102BinaryTreeLevelOrderTraversal();
		List<List<Integer>> res = A.levelOrder(root);
		System.out.println(res);
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