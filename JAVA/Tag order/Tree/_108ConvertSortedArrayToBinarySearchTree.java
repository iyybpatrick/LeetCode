import java.util.*;

public class _108ConvertSortedArrayToBinarySearchTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	private void print_levelOrder (TreeNode root){
		if (root == null) return;
		Stack<TreeNode> stack =new Stack<>();
		Queue<TreeNode> queue=new LinkedList();
		queue.offer(root);
		stack.push(root);
		while (!queue.isEmpty()){
			TreeNode temp=queue.poll();
			if (temp.left != null) queue.offer(temp.left);
			if (temp.right != null) queue.offer(temp.right);
			System.out.print(temp.val+" ");	
		}//while
	}
	private void print_Inorder (TreeNode root){
			if (root == null) return;
		Stack<TreeNode> stack=new Stack();
		TreeNode current=root;
		
		while ( current!=null || !stack.isEmpty()){
			// push it's left child.
			while (current!=null){
				stack.push(current);
				current=current.left;
			}//while
			current=stack.pop();
			System.out.print(current.val+ " ");
			current=current.right;
		}//while
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		
        if (nums == null || nums.length == 0) return null;
        TreeNode root = BuildTree (nums, 0, nums.length-1);
        return root;
    }
	private TreeNode BuildTree(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if (low > high) return null;
		int mid= low + (high-low)/2;
		TreeNode temp= new TreeNode (nums[mid]);
		temp.left= BuildTree (nums, low, mid-1);
		temp.right= BuildTree (nums, mid+1, high);
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,2,3,4,5};
		_108ConvertSortedArrayToBinarySearchTree A=new _108ConvertSortedArrayToBinarySearchTree();
		TreeNode root=A.sortedArrayToBST(nums);
		System.out.println(root.val);
		// A.print_levelOrder(root);
		 A.print_Inorder(root);
		}
	}

