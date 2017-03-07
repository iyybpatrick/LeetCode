import java.util.Stack;

public class _109ConvertSortedListToBinarySearchTree {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 // binary search method
//	 public TreeNode sortedListToBST(ListNode head) {
//	        if (head == null) return null;
//	        ListNode last = head;
//	        while (last.next !=null){
//	        	last= last.next;
//	        }
//	        return BuildTree(head, last);
//	        
//	    }
//	private TreeNode BuildTree(ListNode head, ListNode last) {
//		// TODO Auto-generated method stub
//			if (head == null || last == null ) return null;
//			if (head == last ) return new TreeNode(head.val);
//		 	ListNode fast = head;
//	        ListNode slow = head;
//	        ListNode pre = null;
//	        while (fast.next != null && fast.next.next != null){
//	        	pre = slow;
//	        	slow = slow.next;
//	        	fast = fast.next.next;
//	        }//while
//	        if (pre != null )  pre.next = null;
//	        if (fast.next!=null) fast = fast.next;
//	        TreeNode root = new TreeNode(slow.val);
//	        root.left = BuildTree(head, pre);
//	        root.right = BuildTree(slow.next,fast);
//	        return root;   
//	}
	 
	 public TreeNode sortedListToBST(ListNode head) {
         if (head == null) return null;
         return BuildTree(head, null);
     }
	private TreeNode BuildTree(ListNode head, ListNode tail) {
		// TODO Auto-generated method stub
		if (head == tail) return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast!= tail && fast.next != tail){
			fast = fast.next.next;
			slow = slow.next;
		}//while
		TreeNode root = new TreeNode(slow.val);
		root.left = BuildTree(head,slow);
		root.right = BuildTree(slow.next, tail);
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
		ListNode node1 = new ListNode(-10);
		ListNode node2 = new ListNode(-3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		node1.next = node2; node2.next = node3;node3.next = node4;node4.next = node5;
		_109ConvertSortedListToBinarySearchTree A = new _109ConvertSortedListToBinarySearchTree();
		TreeNode root = A.sortedListToBST(node1);
		A.print_tree(root);
	}

}

//question:
	//Given a singly linked list where elements are sorted in ascending order, 
	//convert it to a height balanced BST.