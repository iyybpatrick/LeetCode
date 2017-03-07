import java.util.*;
public class _23MergeKSortedLists {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
		// Priority Queue
//	 public ListNode mergeKLists(ListNode[] lists) {
//		 	if (lists == null || lists.length == 0 || lists[0] == null) return null;
//	        PriorityQueue <ListNode>queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
//				@Override
//				public int compare(ListNode o1, ListNode o2) {
//					// TODO Auto-generated method stub
//					return o1.val - o2.val;
//				}
//	        });
//	        for (ListNode list : lists){
//	        	if (list != null ){
//	        		queue.add(list);
//	        	}
//	        }//for
//	        ListNode dummy = new ListNode(0);
//	        ListNode tail = dummy;
//	        while (!queue.isEmpty()){
//	        	tail.next = queue.poll();
//	        	tail = tail.next;
//	        	if (tail.next != null){
//	        		queue.offer(tail.next);
//	        	}
//	        }//while
//	        return dummy.next;
//	    }
	
		// Recursion Solution 
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return MergeTwo (lists, 0, lists.length - 1);
	}
	

	private ListNode MergeTwo(ListNode[] lists, int start, int end) {
			// TODO Auto-generated method stub
			if (start == end) return lists[start];
			int mid = (start + end) /2;
			ListNode first = MergeTwo(lists, start, mid);
			ListNode second = MergeTwo(lists, mid + 1,end);
			return merge (first, second);
		}


	private ListNode merge(ListNode first, ListNode second) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode (3);
		ListNode cur = dummy;
		while (first != null && second != null){
			if (first.val < second.val){
				cur.next = first;
				first = first.next;
			}else{
				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
		}//while
		if (first !=null){
			cur.next = first;
		}
		if (second != null){
			cur.next = second;
		}
		return dummy.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode [3];
		ListNode t1 = new ListNode(5);
		ListNode t2 = new ListNode(8);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(10);
		ListNode t5 = new ListNode(3);
		ListNode t6 = new ListNode(7);
		t1.next = t2;
		t3.next = t4;
		t5.next = t6;
		lists[0] = t1; lists[1] = t3; lists[2] = t5;
		_23MergeKSortedLists A = new _23MergeKSortedLists();
		ListNode result = A.mergeKLists(lists);
		while (result != null){
			System.out.println(result.val +" ");
			result = result.next;
		}
		
	}

}
