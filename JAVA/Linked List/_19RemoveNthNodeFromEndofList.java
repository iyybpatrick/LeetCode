

public class _19RemoveNthNodeFromEndofList {

	static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode(0);
        ListNode slow=start;
        ListNode fast=start;
        start.next=head;
        
        //because pointer fast will finally move to null. we have to move it rearward for n+1 times.
        for(int i=1;i<=n+1;i++){
        	fast=fast.next;
        }//for
        while(fast!=null){
        	fast=fast.next;
        	slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_19RemoveNthNodeFromEndofList A=new _19RemoveNthNodeFromEndofList();
		ListNode t1=new ListNode(7);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(1);
		
		t1.next=t2;t2.next=t3;t3.next=t4;
		ListNode start=t1;
		A.removeNthFromEnd(t1, 2);
		while(start!=null)
		{
			System.out.print(start.val+" ");
			start=start.next;
		
		}
		
	}

}

//idea: maintain the gap between slow and fast is n, then move these two pointers rearward together.

//question:
	//Given a linked list, remove the nth node from the end of list and return its head.
	//
	//For example,
	//
	//   Given linked list: 1->2->3->4->5, and n = 2.
	//
	//   After removing the second node from the end, the linked list becomes 1->2->3->5.
	//Note:
	//Given n will always be valid.
	//Try to do this in one pass.