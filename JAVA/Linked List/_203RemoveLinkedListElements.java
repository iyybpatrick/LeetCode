import java.util.*;

public class _203RemoveLinkedListElements {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	public ListNode removeElements(ListNode head, int val) {
       ListNode dummy=new ListNode(0);
       dummy.next=head;
       ListNode cur=head,pre=dummy;
       while(cur!=null){
    	   if(cur.val==val){
    		   pre.next=cur.next;
    	   }//if
    	   else{
    		   pre=cur;
    		
    	   }
   		   cur=cur.next;
       }//while
       return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(1);
		ListNode t3=new ListNode(1);
		ListNode t4=new ListNode(1);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(1);
		ListNode t7=new ListNode(7);
		t1.next=t2;t2.next=t3;t3.next=t4;t4.next=t5;//t5.next=t6;t6.next=t7;
		_203RemoveLinkedListElements A=new _203RemoveLinkedListElements();
		ListNode result=A.removeElements(t1, 1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}

//question:
	//Remove all elements from a linked list of integers that have value val.
	//
	//Example
	//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	//Return: 1 --> 2 --> 3 --> 4 --> 5
	//
	//Credits:
	//Special thanks to @mithmatt for adding this problem and creating all test cases.
	//
