import java.util.*;


public class _160IntersectionofTwoLinkedLists {

	static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int len1=get_length(headA);
	        int len2=get_length(headB);
	        while(len1<len2) {headB=headB.next;len2--;}
	        while(len1>len2) {headA=headA.next;len1--;}
	        while(headA!=headB){
	        	headA=headA.next;
	        	headB=headB.next;
	        }
	        return headA;
	    }
	 public int get_length(ListNode head){
		 int len=0;
		 while(head!=null){
			 head=head.next;
			 len++;
		 }
		 return len;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		ListNode t7=new ListNode(7);
		ListNode t8=new ListNode(8);
		ListNode t9=new ListNode(9);
		ListNode t10=new ListNode(10);
		t1.next=t3;//t3.next=t4;t4.next=t2;
		t5.next=t2;
		_160IntersectionofTwoLinkedLists A=new _160IntersectionofTwoLinkedLists();
		
		ListNode result=A.getIntersectionNode(t1, t5);
		if(result!=null)
		System.out.println(result.val);
	}

}

//question:
	//Write a program to find the node at which the intersection of two singly linked lists begins.
	//
	//
	//For example, the following two linked lists:
	//
	//A:          a1 → a2
	//                   ↘
	//                     c1 → c2 → c3
	//                   ↗            
	//B:     b1 → b2 → b3
	//begin to intersect at node c1.
	//
	//
	//Notes:
	//
	//If the two linked lists have no intersection at all, return null.
	//The linked lists must retain their original structure after the function returns.
	//You may assume there are no cycles anywhere in the entire linked structure.
	//Your code should preferably run in O(n) time and use only O(1) memory.