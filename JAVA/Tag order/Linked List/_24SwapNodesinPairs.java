import java.util.*;

public class _24SwapNodesinPairs {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode swapPairs(ListNode head) {
//		if(head.next==null||head==null)
//			return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode cur=dummy,first,second;
		while(cur.next!=null&&cur.next.next!=null){
			first=cur.next;
			second=first.next;
			cur.next=second;
			first.next=second.next;
			second.next=first;
			cur=cur.next.next;
		}//while
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(3);
		ListNode t1=new ListNode(4);
		ListNode t2=new ListNode(5);
		ListNode t3=new ListNode(6);
		head.next=t1;t1.next=t2;t2.next=t3;
		_24SwapNodesinPairs A=new _24SwapNodesinPairs();
		ListNode result=A.swapPairs(head);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
		
	}

}

//question:
	//Given a linked list, swap every two adjacent nodes and return its head.
	//
	//For example,
	//Given 1->2->3->4, you should return the list as 2->1->4->3.
	//
	//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
	//
	//Subscribe to see which companies asked this question.