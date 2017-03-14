
public class _61RotateList {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 ) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast =dummy;
        ListNode slow = dummy;
        int len = 0;
        for (; fast.next != null; len++){
        	fast = fast.next;
        }
        
        for (int i = len - k % len; i >0; i--){
        	slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_61RotateList A =new _61RotateList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;//l2.next = l3;l3.next = l4;l4.next = l5;
		ListNode res = A.rotateRight(l1, 2);
		while(res != null){
			System.out.print(res.val +" ");
			res = res.next;
		}
	}

}

//question:
	//Given a list, rotate the list to the right by k places, where k is non-negative.
	//
	//For example:
	//Given 1->2->3->4->5->NULL and k = 2,
	//return 4->5->1->2->3->NULL.