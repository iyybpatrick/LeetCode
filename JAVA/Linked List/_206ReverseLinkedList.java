import java.util.*;

public class _206ReverseLinkedList {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,cur=head,then=cur.next;
        while(then!=null){
        	cur.next=then.next;
        	then.next=pre.next;
        	pre.next=then;
        	then=cur.next;
        }//while
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_206ReverseLinkedList A=new _206ReverseLinkedList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		l1.next=l2;l2.next=l3;l3.next=l4;
		ListNode result=A.reverseList(l1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}
// question:
	//Reverse a singly linked list.
