import java.util.*;

public class _129SumRootToLeafNumbers {

	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root, pre = null;
        int one_sum = 0;
        int all_sum = 0;
        while (cur != null || !stack.isEmpty()){
        	while (cur != null){
        		stack.push(cur);
        		one_sum += cur.val;
        		cur=cur.left;
        	}
        	cur = stack.peek();
        	if (cur.left == null && cur.right == null){
        		all_sum += one_sum;
        	}//if
        	if (cur.right != null && cur.right != pre){
        		cur = cur.right;
        	}else{
        		stack.pop();
        		one_sum -= cur.val;
        		pre = cur;
        		cur = null;
        	}//else      	
        }//while
	return all_sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_129SumRootToLeafNumbers A = new _129SumRootToLeafNumbers();
		TreeNode root = new TreeNode(7);
		TreeNode node1 = new TreeNode (5);
		TreeNode node2 = new TreeNode (12);
		TreeNode node3 = new TreeNode (1);
		TreeNode node4 = new TreeNode (2);
		TreeNode node5 = new TreeNode (2);
		TreeNode node6 = new TreeNode (3);
		node1.left=node3; node1.right=node4;
		root.left = node1; root.right=node2;node4.left=node5;node4.right=node6;
		System.out.println(A.sumNumbers(root));
	}

}

//question:
	//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	//
	//An example is the root-to-leaf path 1->2->3 which represents the number 123.
	//
	//Find the total sum of all root-to-leaf numbers.
	//
	//For example,
	//
	//    1
	//   / \
	//  2   3
	//The root-to-leaf path 1->2 represents the number 12.
	//The root-to-leaf path 1->3 represents the number 13.
	//
	//Return the sum = 12 + 13 = 25.