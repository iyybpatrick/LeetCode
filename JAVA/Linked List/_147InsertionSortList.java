import java.util.*;


public class _147InsertionSortList {

	 static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	 public ListNode insertionSortList(ListNode head) {
	       if(head==null) return null;
	       ListNode dummy=new ListNode(0);
	       ListNode pre=dummy;
	       ListNode cur=head;
	       // add node to new list one by one
	       while(cur!=null){
	    	   pre=dummy;
	    	   // find it's position to be added
	    	   while(pre.next!=null&&pre.next.val<cur.val){
	    		   pre=pre.next;
	    	   }//while
	    	   // add this node to new list
	    	   ListNode next=cur.next;
	    	   cur.next=pre.next;
	    	   pre.next=cur;
	    	   cur=next;
	       }//while
	       return dummy.next;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_147InsertionSortList A=new _147InsertionSortList();
		ListNode t1=null;//new ListNode(2);
		ListNode t2=new ListNode(1);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		ListNode t6=new ListNode(6);
		//t1.next=t2;t2.next=t3;t3.next=t4;//t4.next=t5;t5.next=t5;
		ListNode result=A.insertionSortList(t1);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
		
	}

}

//question:
	//Sort a linked list using insertion sort.