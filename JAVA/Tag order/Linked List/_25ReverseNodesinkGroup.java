import java.util.*;

import _23MergekSortedLists.ListNode;

public class _25ReverseNodesinkGroup {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	 public ListNode reverseKGroup(ListNode head, int k) {
	        if(head==null||head.next==null||k<2) return head;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode pre=dummy,tail=dummy,temp;
	        int count;
	        while(true){
	        	count=k;
	        	while(count>0&&tail!=null){
	        		count--;
	        		tail=tail.next;
	        	}
	        	if(tail==null) break;
	        	head=pre.next;
	        	while(pre.next!=tail){
	        		temp=pre.next;
	        		pre.next=temp.next;
	        		temp.next=tail.next;
	        		tail.next=temp;
	        	}//while
	        	tail=head;
	        	pre=head;
	        }//while
	        
	        return dummy.next;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_25ReverseNodesinkGroup A=new _25ReverseNodesinkGroup();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;
		ListNode result=A.reverseKGroup(t1, 3);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
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