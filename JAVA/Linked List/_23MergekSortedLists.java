import java.util.*;

public class _23MergekSortedLists {

	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
        	return null;
        PriorityQueue<ListNode> queue=new PriorityQueue(lists.length,new Comparator<ListNode>(){
        	public int compare(ListNode v1,ListNode v2){
        		return v1.val-v2.val;
        	}
        });
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        for(int i=0;i<lists.length;i++){
        	queue.add(lists[i]);
        }//for
        while(!queue.isEmpty()){
        	cur.next=queue.poll();
        	cur=cur.next;
        	if(cur.next!=null)
        		queue.add(cur.next);
        }//while
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_23MergekSortedLists A=new _23MergekSortedLists();
		ListNode t1=new ListNode(4);
		ListNode t2=new ListNode(6);
		ListNode t3=new ListNode(8);
		ListNode t4=new ListNode(3);
		ListNode t5=new ListNode(7);
		ListNode t6=new ListNode(1);
		t1.next=t2;t2.next=t3;
		t4.next=t5;
		
		ListNode[] lists=null;
		ListNode result=A.mergeKLists(lists);
		while(result!=null){
			System.out.print(result.val+" ");
			result=result.next;
		}
	}

}
//question:
	//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
