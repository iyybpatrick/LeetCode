import java.util.*;

public class _113PathSumII {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		 List<List<Integer>> res = new LinkedList<>();
		 if (root == null) return res;
		 Stack <Integer> stack = new Stack<>();
		 Add_path(res, stack, root, 0, sum);
		 return res;
	}
	private void Add_path(List<List<Integer>> res, Stack <Integer> stack, TreeNode root,int cur_sum, int sum) {
		// TODO Auto-generated method stub
		if (root == null) return;
		stack.push(root.val);
		cur_sum += root.val;
		if (root.left == null && root.right == null && cur_sum == sum){
			res.add(new ArrayList<Integer>(stack));
		}
		Add_path (res, stack, root.left, cur_sum, sum);
		Add_path (res, stack, root.right, cur_sum, sum);
		stack.pop();
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);
		root.left = node1; root.right = node2;
		node1.left =node3; 
		node2.left =node4; node2.right =node5;
		node3.left = node6; node3.right = node7;
		node5.left = node8; node5.right =node9;
		_113PathSumII A = new _113PathSumII();
		List<List<Integer>> res = A.pathSum(root, 22);
		System.out.println(res);
	}

}

//question:
	//Given a binary tree and a sum, find all root-to-leaf paths
	//where each path's sum equals the given sum.
	//
	//For example:
	//Given the below binary tree and sum = 22,
	//              5
	//             / \
	//            4   8
	//           /   / \
	//          11  13  4
	//         /  \    / \
	//        7    2  5   1
	//return
	//[
	//   [5,4,11,2],
	//   [5,8,4,5]
	//]
