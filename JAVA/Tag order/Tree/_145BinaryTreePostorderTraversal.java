import java.util.*;


public class _145BinaryTreePostorderTraversal {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
//	public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> result =new LinkedList<>();
//        traverse (root,result);
//        return result;
//    }
//	private List<Integer> traverse(TreeNode root, List<Integer> result) {
//		// TODO Auto-generated method stub
//		if (root == null) return result;
//		traverse (root.left, result);
//		traverse (root.right, result);
//		result.add(root.val);
//		return result;
//		
//	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result =new LinkedList<>();
        if (root == null )return result;
        
        List<Integer> left = postorderTraversal (root.left);
        List<Integer> right = postorderTraversal (root.right);
        
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_145BinaryTreePostorderTraversal A = new _145BinaryTreePostorderTraversal();
		TreeNode root =new TreeNode (7);
		TreeNode node1 = new TreeNode (4);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (3);
		TreeNode node4 = new TreeNode (10);
		TreeNode node5 = new TreeNode (9);
		TreeNode node6 = new TreeNode (14);
		root.left = node1; root.right = node4;
		node1.left = node2; node2.right = node3;
		node4.left = node5; node4.right = node6;
		List<Integer> result = A.postorderTraversal(root);
		System.out.println(result);
	}

}

//question:
	//Given a binary tree, return the postorder traversal of its nodes' values.
	//
	//For example:
	//Given binary tree {1,#,2,3},
	//   1
	//    \
	//     2
	//    /
	//   3
	//return [3,2,1].