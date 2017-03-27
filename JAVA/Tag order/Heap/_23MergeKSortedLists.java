/**
 * Created by YuebinYang on 2017/3/26.
 */
import java.util.*;
public class _23MergeKSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare (ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists){
            if (list != null)
            queue.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!queue.isEmpty()){
            p .next = queue.poll();
            p = p.next;

            if (p.next != null){
                queue.offer(p.next);
            }
        }//while
        return dummy.next;
    }

    public static void main(String[] args){
        _23MergeKSortedLists  A=new _23MergeKSortedLists ();
        ListNode t1=new ListNode(4);
        ListNode t2=new ListNode(6);
        ListNode t3=new ListNode(8);
        ListNode t4=new ListNode(3);
        ListNode t5=new ListNode(7);
        ListNode t6=new ListNode(1);
        t1.next=t2;t2.next=t3;
        t4.next=t5;

        ListNode[] lists={t1,t4};
        ListNode result=A.mergeKLists(lists);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }

    }
}

//question:
//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

