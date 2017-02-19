import java.util.*;
public class _61RotateList {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null||k==0) return head;
        int len=1;
        ListNode cur=head,tail=head;
        while(tail.next!=null){
        	len++;
        	tail=tail.next;
        }
        //to find the break point, move k steps
        k=len-k%len;
        if(k==0) return head;
        tail.next=head;
        while(k!=1){
           cur=cur.next; 	
           k--;
        }
        head=cur.next;
        cur.next=null;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_61RotateList A=new _61RotateList();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;
		ListNode result= A.rotateRight(t1, 14);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//Given a list, rotate the list to the right by k places, where k is non-negative.
	//
	//For example:
	//Given 1->2->3->4->5->NULL and k = 2,
	//return 4->5->1->2->3->NULL.

