import java.util.*;

import java.util.*;
public class _257BinaryTreePaths {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 public List<String> binaryTreePaths(TreeNode root) {
		 List<String> res = new LinkedList<>();
		 StringBuilder path = new StringBuilder();
		 if (root != null){
			 DFS(root, path,res);
		 }
		 return res;
	 }
	private void DFS(TreeNode root, StringBuilder path, List<String> res) {
		// TODO Auto-generated method stub
		if (root == null) return;
		
		if (root.left == null && root.right == null){
			path.append(root.val);
			res.add(path.toString());
			int root_val = CountDigit(root.val);
			if (root.val < 0) root_val++;
			path.delete(path.length() - root_val, path.length());
			return;
		}else{
			path.append(root.val + "->");
		}
		DFS(root.left, path, res);
		DFS(root.right, path, res);
		int root_val = CountDigit(root.val);
		if (root.val < 0) root_val++;
		path.delete(path.length() - root_val - 2, path.length());
	}
	private int CountDigit(int val) {
		// TODO Auto-generated method stub
		int count = 1;
		while (val /10 !=0){
			val = val/10;
			count++;
		}
		return count;
	}
	
//	public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new LinkedList<>();
//        if (root != null) {
//        Find_path (root, "", result);
//        }
//        return result;
//    }
//private void Find_path(TreeNode root, String path, List<String> result) {
//	// TODO Auto-generated method stub
//	if (root.left == null && root.right == null){
//		result.add(path+root.val); return;
//	}
//	if (root.left != null){
//		Find_path (root.left, path + root.val + "->", result);
//	}
//	if (root.right != null){
//		Find_path (root.right, path + root.val + "->", result);
//	}
//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(2);
		root.left = node1; root.right = node2;
		node1.left = node3; 
		_257BinaryTreePaths A = new _257BinaryTreePaths();
		List<String> res = A.binaryTreePaths(root);
		System.out.println(res);
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