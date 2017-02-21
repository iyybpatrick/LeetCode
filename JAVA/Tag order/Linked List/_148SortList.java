import java.util.*;

public class _148SortList {

	 static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }//while
        fast=slow.next;
        slow.next=null;
        //sort each half.
        ListNode l1=sortList(head);
        ListNode l2=sortList(fast);
        return merge(l1,l2);
        
    }
	public ListNode merge(ListNode l1,ListNode l2){
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				cur.next=l1;
				l1=l1.next;
			}//if
			else{
				cur.next=l2;
				l2=l2.next;
			}//else
			cur=cur.next;
		}//while
		
		if(l1!=null) cur.next=l1;
		if(l2!=null) cur.next=l2;
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_148SortList A=new _148SortList();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		t1.next=t2;t2.next=t3;t3.next=t4;//t4.next=t5;t5.next=t5;
		ListNode result=A.sortList(t1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//
	//Sort a linked list in O(n log n) time using constant space complexity.