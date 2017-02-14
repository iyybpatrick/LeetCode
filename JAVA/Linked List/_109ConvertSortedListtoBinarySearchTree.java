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
		        if(head==null) return null;
		        TreeNode t_head=new TreeNode(head.val); head=head.next;
		        while(head!=null){
		        	
		        	//smaller
		        	if(head.val<t_head.val){
		        		t_head.left=Tree_add(t_head.left,head.val);
		        	}
		        	//bigger
		        	else{
		        		System.out.println("heihei");
		        		t_head.right=Tree_add(t_head.right,head.val);
		        	}
		        	head=head.next;
		        }//while
		        return t_head;
		    }
		  public TreeNode Tree_add(TreeNode sub_head,int value){
			  if(sub_head==null){
				 sub_head=new TreeNode(value);
				 return sub_head;
			  }
			  //smaller
			  else if(value<sub_head.val){
				  sub_head.left=Tree_add(sub_head.left,value);
			  }
			  else{
				  sub_head.right=Tree_add(sub_head.right,value);
			  }
			  return null;
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
		System.out.println("heihei");
		A.tree_print(t_head);
		while(t_head!=null){
			System.out.print(t_head.val+" ");
			t_head=t_head.right;
		}
		
	}

}

//question;
	//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

