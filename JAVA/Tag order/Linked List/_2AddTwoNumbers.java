
public class _2AddTwoNumbers {

	static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev=new ListNode(0);
        ListNode head=prev;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
        	int sum= (l1==null? 0:l1.val)+(l2==null? 0:l2.val)+carry;
        	carry=sum/10;
        	sum=sum%10;
        	ListNode cur=new ListNode(sum);
        	prev.next=cur;
        	prev=cur;
        	l1= (l1==null? l1:l1.next);
        	l2=(l2==null? l2:l2.next);
        }//while
        return head.next;
    }//addTwoNumber
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_2AddTwoNumbers A=new _2AddTwoNumbers();
		ListNode test1=new ListNode(7);
		ListNode test2=new ListNode(2);
		ListNode test3=new ListNode(9);
		test1.next=test2;test2.next=test3;
		ListNode test4=new ListNode(3);
		ListNode test5=new ListNode(8);
//		ListNode test6=new ListNode(4);
		test4.next=test5;//test5.next=test6;
		ListNode result=A.addTwoNumbers(test1, test4);
		while(result!=null){
			System.out.print(result.val);
			result=result.next;
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