import java.util.*;

public class _234PalindromeLinkedList {
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public boolean isPalindrome(ListNode head) {
		if(head==null||head.next==null) return true;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }//while
        ListNode pre=slow;
        ListNode cur=pre.next;
        ListNode then=null;
        if(cur.next!=null) then=cur.next;
        //reverse nodes after mid
        while(cur!=null&&then!=null){
        	cur.next=then.next;
        	then.next=pre.next;
        	pre.next=then;
        	then=cur.next;
        }//
        slow=slow.next;
        cur=head;
        while(slow!=null){
        	if(cur.val!=slow.val)
        		return false;
        	slow=slow.next;
        	cur=cur.next;
        }
//        while(head!=null){
//        	System.out.print(head.val+" ");
//        	head=head.next;
//        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_234PalindromeLinkedList A=new _234PalindromeLinkedList();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(3);
		ListNode l5=new ListNode(2);
		ListNode l6=new ListNode(1);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;
		System.out.println(A.isPalindrome(l1));
	}

}


//question:
	//Given a singly linked list, determine if it is a palindrome.
	//
	//Follow up:
	//Could you do it in O(n) time and O(1) space?