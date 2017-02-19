import java.util.*;


public class _86PartitionList {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode partition(ListNode head, int x) {
		ListNode dummy_s=new ListNode(0);
		ListNode dummy_b=new ListNode(0);
		ListNode curs=dummy_s;
		ListNode curb=dummy_b;
		while(head!=null){
			if(head.val<x){
				curs.next=head;
				curs=curs.next;
			}//if
			else{
				curb.next=head;
				curb=curb.next;
			}
			head=head.next;
		}//while
		curb.next=null;
		curs.next=dummy_b.next;
		return dummy_s.next;		
    }//partition
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_86PartitionList A=new _86PartitionList();
		ListNode t1=new ListNode(3);
		ListNode t2=new ListNode(1);
		ListNode t3=new ListNode(2);
		ListNode t4=new ListNode(3);
		ListNode t5=new ListNode(1);
		ListNode t6=new ListNode(6);
		t1.next=t2;//t2.next=t3;t3.next=t4;t4.next=t5;t5.next=t6;
		ListNode result=A.partition(t1, 3);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}

   }
}

//question:
	//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	//
	//You should preserve the original relative order of the nodes in each of the two partitions.
	//
	//For example,
	//Given 1->4->3->2->5->2 and x = 3,
	//return 1->2->2->4->3->5.                        