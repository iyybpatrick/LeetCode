import java.util.*;

import javax.xml.transform.Result;


public class _143ReorderList {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) return;
        ListNode fast=head;
        ListNode slow=head;
        //find mid and save it to slow.
        while(fast.next!=null&&fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        
        //reverse nodes after mid.
        ListNode pre=slow;
        ListNode cur_after=slow.next;
        ListNode next=cur_after.next;
        while(next!=null){
        	cur_after.next=next.next;
        	next.next=pre.next;
        	pre.next=next;
        	next=cur_after.next;
        }//while
        
        //insert node after mid to before mid
        ListNode cur_before=head;
        cur_after=pre.next;
        pre.next=null;
        while(cur_after!=null){
        	ListNode temp=cur_after.next;
        	cur_after.next=cur_before.next;
        	cur_before.next=cur_after;
        	cur_before=cur_after.next;
        	cur_after=temp;
        }//while 
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		ListNode t7=new ListNode(7);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;t5.next=t6;//t6.next=t7;
		_143ReorderList A=new _143ReorderList();
		A.reorderList(t1);
		while(t1!=null){
			System.out.print(t1.val+" ");
			t1=t1.next;
		}
	}

}

//question:
	//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	//
	//You must do this in-place without altering the nodes' values.
	//
	//For example,
	//Given {1,2,3,4}, reorder it to {1,4,2,3}.