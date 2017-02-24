import java.util.*;

public class _112PathSum {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack =new Stack <TreeNode>();
		if (root == null) return false;
		TreeNode cur=root;
		TreeNode pre=null;
		int sum_remain=sum;
		while (cur !=null || !stack.isEmpty()){
			while (cur != null){
				stack.push(cur);
				sum_remain -= cur.val;
				cur=cur.left;
			}//while
			cur=stack.peek();
			if (sum_remain == 0 &&cur.left == null && cur.right == null) return true;
			if (cur.right != null && pre !=cur.right){
				cur=cur.right;
			}//if
			else {
			pre=cur;
			sum_remain += cur.val;
			stack.pop();
			cur=null;
			}//else
		}//while
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1=new TreeNode (5);
		TreeNode node2=new TreeNode (4);
		TreeNode node3=new TreeNode (8);
		TreeNode node4=new TreeNode (11);
		TreeNode node5=new TreeNode (13);
		TreeNode node6=new TreeNode (4);
		TreeNode node7=new TreeNode (7);
		TreeNode node8=new TreeNode (2);
		TreeNode node9=new TreeNode (1);
//		node1.left=node2;node1.right=node3;node2.left=node4;node3.left=node5;node3.right=node6;
//		node4.left=node7;node4.right=node8; node6.right=node9;
		_112PathSum A=new _112PathSum();
		System.out.println(A.hasPathSum(node1, 0));
	}

}

//question:
	//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
	//
	//For example:
	//Given the below binary tree and sum = 22,
	//              5
	//             / \
	//            4   8
	//           /   / \
	//          11  13  4
	//         /  \      \
	//        7    2      1
	//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	//
	//Subscribe to see which companies asked this question.