import java.util.*;
public class _2AddTwoNumbers {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
        	sum = carry + l1.val + l2.val;
        	carry = sum/10;
        	cur.next = new ListNode(sum % 10);
        	cur = cur.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }//while
        
        while (l1 != null){
        	sum = carry + l1.val;
        	carry = sum/10;
        	cur.next = new ListNode(sum % 10);
        	cur = cur.next;
        	l1 = l1.next;
        }
        
        while (l2 != null){
        	sum = carry + l2.val;
        	carry = sum/10;
        	cur.next = new ListNode(sum % 10);
        	cur = cur.next;
        	l2 = l2.next;
        }
        
        if (carry != 0){
        	cur.next = new ListNode(carry);
        }
        
        return dummy.next; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root1 = new ListNode (2);
		ListNode root2 = new ListNode (5);
		ListNode node1 = new ListNode (4);
		ListNode node2 = new ListNode (3);
		ListNode node3 = new ListNode (6);
		ListNode node4 = new ListNode (4);
		root1.next = node1; node1.next = node2;
		root2.next = node3; node3.next = node4;
		_2AddTwoNumbers A =new _2AddTwoNumbers();
		ListNode res = A.addTwoNumbers(root1, root2);
		while (res!=null){
			System.out.print(res.val +" ");
			res = res.next;
		}
		
	}

}
//question:
	//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	//
	//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	//
	//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	//Output: 7 -> 0 -> 8