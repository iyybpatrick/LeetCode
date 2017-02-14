import java.util.*;

public class _25ReverseNodesinkGroup {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	 public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode dummy=new ListNode (0);
	        dummy.next=head;
	        int count=k;
	        ListNode last=dummy,cur=dummy,first=dummy.next;
	        
	        while(last.next!=null&&count!=0){
	        	last=last.next;
	        	count--;
	        }//while
	        if(count==0){
	        	
	        }//if
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5