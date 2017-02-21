
public class _21MergeTwoSortedLists {

	static public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
        	return l2;
        if(l2==null)
        	return l1;
        ListNode merge;
        //merge l1
        if(l1.val<l2.val){
        	merge=l1;
        	merge.next=mergeTwoLists(l1.next,l2);
        }
        //merge l2
        else {
        	merge=l2;
        	merge.next=mergeTwoLists(l1,l2.next);
        }
        return merge;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_21MergeTwoSortedLists A=new _21MergeTwoSortedLists();
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(6);
		ListNode l3=new ListNode(7);
		ListNode l4=new ListNode(9);
		l1.next=l2;l2.next=l3;l3.next=l4;
		ListNode l5=new ListNode(1);
		ListNode l6=new ListNode(4);
		ListNode l7=new ListNode(5);
		ListNode l8=new ListNode(8);
		l5.next=l6;l6.next=l7;l7.next=l8;
		A.mergeTwoLists(l1, l5);
		ListNode test=l1;
		while(test!=null)
		{
			System.out.print(test.val+"  ");
			test=test.next;
		}
	}

}

//question:
//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.

	