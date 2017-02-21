import java.util.*;

import java.util.*;

public class _328OddEvenLinkedList {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return head;
        ListNode pre=head;
        ListNode cur=pre.next;
        ListNode then=cur.next;
        while(then!=null){
        	//if(then.next!=null)
        	cur.next=then.next;
        	then.next=pre.next;
        	pre.next=then;
        	pre=then;
        	then=cur.next;
        	cur=cur.next;
        	if(then!=null) then=then.next;
        	else break; 
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		_328OddEvenLinkedList A=new _328OddEvenLinkedList();
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;l6.next=l7;l7.next=l8;
		ListNode result=A.oddEvenList(l1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
	//
	//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
	//
	//Example:
	//Given 1->2->3->4->5->NULL,
	//return 1->3->5->2->4->NULL.
	//
	//Note:
	//The relative order inside both the even and odd groups should remain as it was in the input. 
	//The first node is considered odd, the second node even and so on ...