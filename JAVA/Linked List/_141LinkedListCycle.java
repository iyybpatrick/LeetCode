import java.util.*;

public class _141LinkedListCycle {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 public boolean hasCycle(ListNode head) {
	        if(head==null) return false;
	        ListNode onestep=head;
	        ListNode twostep=head;
	        while(twostep.next!=null&&twostep.next.next!=null){
	        	onestep=onestep.next;
	        	twostep=twostep.next.next;
	        	if(onestep==twostep) return true;
	        }//while
	        return false;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_141LinkedListCycle A=new _141LinkedListCycle();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		//t1.next=t1;
		t1.next=t2;t2.next=t3;t3.next=t1;t4.next=t5;t5.next=t1;
		System.out.print(A.hasCycle(t1));
		
	}

}

//question:
	//Given a linked list, determine if it has a cycle in it.
	//
	//Follow up:
	//Can you solve it without using extra space?