import java.util.*;

import javax.xml.soap.Node;
public class _230KthSmallestElementInABST {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public int kthSmallest1(TreeNode root, int k){
		//brute force with stack
      if (root == null ) return 0;
      Stack<TreeNode> stack =new Stack <TreeNode>();
      TreeNode cur = root;
      while ( cur != null || !stack.isEmpty()){
      	while (cur !=null){
      		stack.push(cur);
          	cur=cur.left;
      	}//while
      	cur=stack.pop();
      	k--;
      	if (k == 0){
      		return cur.val;
      	}
      	cur=cur.right;
      }//while
      return 0;
	}
	public int kthSmallest(TreeNode root, int k) {
		
		
		int count = Count_tree (root.left);
		if (count + 1 == k){
			return root.val;
		}else if ( k <= count){
			return kthSmallest (root.left, k);
		}else{
			return kthSmallest (root.right, k-count-1);
		}
    }
	private int Count_tree(TreeNode left) {
		// TODO Auto-generated method stub
		if (left == null){
			return 0;
		}
		return 1 + Count_tree(left.left) + Count_tree(left.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_230KthSmallestElementInABST A= new _230KthSmallestElementInABST();
		TreeNode root = new TreeNode (6);
		TreeNode node1 = new TreeNode (3);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (4);
		TreeNode node4 = new TreeNode (8);
		root.left=node1; root.right=node4; node1.left=node2;node1.right=node3;
		System.out.println(A.kthSmallest(root, 5));
	}

}

//question:
	//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	//
	//Note: 
	//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	//
	//Follow up:
	//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

