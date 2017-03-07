import java.util.*;
public class _108ConvertSortedArrayToBinarySearchTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		int len = nums.length;
		return BuildTree(nums, 0, len - 1 );
	}
	private TreeNode BuildTree(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if (low >high) return null;
		if (low == high) return new TreeNode(nums[low]);
		int mid = low + (high - low)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = BuildTree(nums, low, mid-1);
		root.right = BuildTree(nums, mid+1, high);
		
		return root;
	}
	private void print_tree (TreeNode root){
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()){
			while (cur != null){
				stack.push(cur);
				cur = cur.left;
				
			}
			cur = stack.pop();
			System.out.println(cur.val +" ");
			cur = cur.right;
		}//while
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {2,4,5,7,9};
		_108ConvertSortedArrayToBinarySearchTree  A = new _108ConvertSortedArrayToBinarySearchTree ();
		TreeNode root =A.sortedArrayToBST(nums);
		A.print_tree(root);
	}

}

//question:
	//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	//
