import java.util.*;
public class _83RemoveDuplicatesfromSortedList {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode cur=head;
        while(cur.next!=null){
        	if(cur.val==cur.next.val){
        		cur.next=cur.next.next;
        	}//if
        	else{
        		cur=cur.next;
        	}//else
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_83RemoveDuplicatesfromSortedList A=new _83RemoveDuplicatesfromSortedList();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(1);
		ListNode t3=new ListNode(1);
		ListNode t4=new ListNode(3);
		ListNode t5=new ListNode(3);
		ListNode t6=new ListNode(6);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;
		ListNode result=A.deleteDuplicates(t1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//Given a sorted linked list, delete all duplicates such that each element appear only once.
	//
	//For example,
	//Given 1->1->2, return 1->2.
	//Given 1->1->2->3->3, return 1->2->3.