
public class _19RemoveNthNodeFromEndOfList {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0 ; i < n; i++){
        	fast = fast.next;
        }
        while (fast.next != null){
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_19RemoveNthNodeFromEndOfList A =new _19RemoveNthNodeFromEndOfList();
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		//head.next = l1; l1.next = l2; l2.next =l3; l3.next = l4;
		ListNode res = A.removeNthFromEnd(head, 1);
		while (res != null){
			System.out.println(res.val +" ");
			res = res.next;
		}
	}

}

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