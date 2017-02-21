import java.util.*;

public class _445AddTwoNumbersII {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();
        while(l1!=null){
        	s1.push(l1.val);
        	l1=l1.next;
        }
        while(l2!=null){
        	s2.push(l2.val);
        	l2=l2.next;
        }
        int sum=0;
        ListNode node=new ListNode(0);
        while(!s1.empty()||!s2.empty()){
        	if(!s1.empty()) sum+=s1.pop();
        	if(!s2.empty()) sum+=s2.pop();      	
        	node.val=sum%10;
        	ListNode head=new ListNode(sum/10);
        	head.next=node;
        	node=head;
        	sum=sum/10;
        }//while
        return node.val==0 ? node.next:node;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_445AddTwoNumbersII A=new _445AddTwoNumbersII();
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(9);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(6);
		ListNode l7=new ListNode(7);
		ListNode l8=new ListNode(8);
		l1.next=l2;l3.next=l4;
		ListNode result=A.addTwoNumbers(l1, l3);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	//
	//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	//
	//Follow up:
	//What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
	//
	//Example:
	//
	//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	//Output: 7 -> 8 -> 0 -> 7