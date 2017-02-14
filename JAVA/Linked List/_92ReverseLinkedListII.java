import java.util.*;

public class _92ReverseLinkedListII {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null) return head;
        ListNode dummy=new ListNode (0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=0;i<m-1;i++) prev=prev.next;
        
        ListNode start=prev.next;
        ListNode next=start.next;
        for(int i=0;i<n-m;i++){
        	start.next=next.next;
        	next.next=prev.next;
        	prev.next=next;
        	next=start.next;
        }//for
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_92ReverseLinkedListII A=new _92ReverseLinkedListII();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		t1.next=t2;t2.next=t3;t3.next=t4;//t4.next=t5;t5.next=t6;
		ListNode result=A.reverseBetween(t1, 2, 4);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}//while
	}
}

//question:
	//Reverse a linked list from position m to n. Do it in-place and in one-pass.
	//
	//For example:
	//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	//
	//return 1->4->3->2->5->NULL.