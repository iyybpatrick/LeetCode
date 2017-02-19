import java.util.*;

public class _109ConvertSortedListtoBinarySearchTree {

		  static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
		 	
		  static public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		  public TreeNode sortedListToBST(ListNode head) {
		        if(head==null)  return null;
		        return create_tree(head,null);
		    }
		  public TreeNode create_tree(ListNode head,ListNode tail){
			  if(head==tail)  return null;
			  ListNode slow=head;
			  ListNode fast=head;
			  
			  while(fast!=tail&&fast.next!=tail){
				  fast=fast.next.next;
				  slow=slow.next;
			  }//while
			  TreeNode t_head=new TreeNode(slow.val);
			  t_head.left=create_tree(head,slow);
			  t_head.right=create_tree(slow.next,tail);
			  return t_head;
		  }
		  
		  public void tree_print(TreeNode head){
			  if(head.left!=null){
				  tree_print(head.left);
			  }
			  System.out.print(head.val+" ");
			  if(head.right!=null){
				  tree_print(head.right);
			  }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_109ConvertSortedListtoBinarySearchTree A=new _109ConvertSortedListtoBinarySearchTree();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;t5.next=t6;
		TreeNode t_head=A.sortedListToBST(t1);
		A.tree_print(t_head);
		
	}

}

//question;
	//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

