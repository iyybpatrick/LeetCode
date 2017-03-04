import java.util.*;

public class _257BinaryTreePaths {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public List<String> binaryTreePaths(TreeNode root) {
	        List<String> result = new LinkedList<>();
	        if (root != null) {
	        Find_path (root, "", result);
	        }
	        return result;
	    }
	private void Find_path(TreeNode root, String path, List<String> result) {
		// TODO Auto-generated method stub
		if (root.left == null && root.right == null){
			result.add(path+root.val); return;
		}
		if (root.left != null){
			Find_path (root.left, path + root.val + "->", result);
		}
		if (root.right != null){
			Find_path (root.right, path + root.val + "->", result);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_257BinaryTreePaths A= new _257BinaryTreePaths();
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
		List<String> result = A.binaryTreePaths(root);
		System.out.println(result);
	}

}

//question:
	//Given a binary tree, return all root-to-leaf paths.
	//
	//For example, given the following binary tree:
	//
	//   1
	// /   \
	//2     3
	// \
	//  5
	//All root-to-leaf paths are:
	//
	//["1->2->5", "1->3"]