import java.util.*;

public class _94BinaryTreeInorderTraversal {
	
	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<>();
		if (root ==null) return result;
	
		Stack<TreeNode> stack=new Stack();
		TreeNode current=root;
		
		while ( current!=null || !stack.isEmpty()){
			// push it's left child.
			while (current!=null){
				stack.push(current);
				current=current.left;
			}//while
			current=stack.pop();
			result.add(current.val);
			current=current.right;
		}//while
		
		return result;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_94BinaryTreeInorderTraversal A=new _94BinaryTreeInorderTraversal();
		TreeNode node1=new TreeNode (3);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (4);
		node1.left=node2; node1.right=node3; node3.left=node4;
		List<Integer> result=A.inorderTraversal(node1);
		System.out.println(result);
		
	}

}

//question:
	//Given a binary tree, return the inorder traversal of its nodes' values.
	//
	//For example:
	//Given binary tree [1,null,2,3],
	//   1
	//    \
	//     2
	//    /
	//   3
	//return [1,3,2].
	//Note: Recursive solution is trivial, could you do it iteratively?