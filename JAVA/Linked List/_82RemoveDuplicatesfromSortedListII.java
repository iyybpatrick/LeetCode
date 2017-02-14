import java.util.*;

public class _82RemoveDuplicatesfromSortedListII {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }	
	 public ListNode deleteDuplicates(ListNode head) {
	        if(head==null||head.next==null){
	        	return head;
	        }
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode cur=head,prev=dummy;
	        //still processing
	        while(cur!=null&&cur.next!=null){
	        	//not delete
	        	if(cur.val!=cur.next.val){
	        		prev=cur;
	        		cur=cur.next;
	        		continue;
	        	}
	        	//delete
	        	while(cur.next!=null&&cur.val==cur.next.val){
	        		cur=cur.next;
	        	}//while
	        	prev.next=cur.next;
	        	cur=cur.next;
	        }//while
	        return dummy.next;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_82RemoveDuplicatesfromSortedListII A=new _82RemoveDuplicatesfromSortedListII();
		ListNode t1=new ListNode(2);
		ListNode t2=new ListNode(3);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(3);
		ListNode t5=new ListNode(4);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;
		ListNode result=A.deleteDuplicates(t1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:

	//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	//
	//For example,
	//Given 1->2->3->3->4->4->5, return 1->2->5.
	//Given 1->1->1->2->3, return 2->3.