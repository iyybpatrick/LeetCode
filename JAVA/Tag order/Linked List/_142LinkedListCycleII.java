import java.util.*;

public class _142LinkedListCycleII {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null) return null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        	if(fast==slow){
        		ListNode slow2=head;
        		while(slow!=slow2){
        			slow=slow.next;
        			slow2=slow2.next;
        		}//while
        		return slow;
        	}//if
        }//while
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_142LinkedListCycleII A=new _142LinkedListCycleII();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		t1.next=t2;//t2.next=t3;t3.next=t4;t4.next=t5;t5.next=t5;
		ListNode result=A.detectCycle(t1);
		if(result==null)System.out.print("no");
		//System.out.print(A.detectCycle(t1).val);
	}

}

//question:
	//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	//
	//Note: Do not modify the linked list.
	//
	//Follow up:
	//Can you solve it without using extra space?
