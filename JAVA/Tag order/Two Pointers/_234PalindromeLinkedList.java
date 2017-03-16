
public class _234PalindromeLinkedList {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
        ListNode fast = head, slow = head;
        while (fast!= null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode reversed = reverse(slow);
        while (reversed != null){
        	if (reversed.val != head.val){
        		return false;
        	}
        	reversed = reversed.next; 
        	head = head.next;
        }
        return true;
    }
	private ListNode reverse(ListNode head) {
		// TODO Auto-generated method stub
		ListNode prev = null;
		ListNode next = null;
		while (head != null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_234PalindromeLinkedList A =new _234PalindromeLinkedList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(1);
		l1.next = l2; l2.next = l3; l3.next =l4; l4.next = l5; l5.next = l6;
		System.out.println(A.isPalindrome(l1));
	}

}

//question:
	//Given a singly linked list, determine if it is a palindrome.
	//
	//Follow up:
	//Could you do it in O(n) time and O(1) space?