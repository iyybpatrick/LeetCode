import java.util.*;
public class _113PathSumII {
	private List<List<Integer>> result = new ArrayList<>();
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if (root == null )return result;
        Stack<Integer> stack = new Stack<>();
      
        Add_path (stack, sum, root);
        return result;
        
    }
	private void Add_path(Stack<Integer> stack, int sum, TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return;
		stack.push(root.val);
		if (root.left == null && root.right == null){
			if (sum == root.val) result.add(new ArrayList<Integer>(stack));
		}
		if (root.left != null) Add_path (stack, sum - root.val, root.left);
		if (root.right!= null) Add_path (stack, sum - root.val, root.right);
		stack.pop();
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_113PathSumII  A=new _113PathSumII ();
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
		root.left=node1; root.right=node2; node1.left=node3; node3.left=node6;node3.right=node7;
		node2.left = node4;node2.right=node5;node5.left=node8;node5.right=node9;
		List<List<Integer>> result = A.pathSum(root, 22);
		System.out.println(result);
	}

}

//question:
	//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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