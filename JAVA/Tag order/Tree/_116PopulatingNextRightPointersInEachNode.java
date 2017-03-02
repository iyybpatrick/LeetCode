import java.util.*;
public class _116PopulatingNextRightPointersInEachNode {

	public static class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
	public void connect(TreeLinkNode root) {
        Queue <TreeLinkNode> queue = new LinkedList<>();
        if ( root == null) {
        	return;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
        	int size = queue.size();
        	TreeLinkNode temp;
        	for (int i = 0; i < size; i ++){
        		temp=queue.poll();
        		temp.next = i == size-1 ? null : queue.peek();
        		if (temp.left != null)  queue.offer(temp.left);
        		if (temp.right != null) queue.offer(temp.right);
        	}//for  	
        }
    }
	public static void print_node_next (TreeLinkNode node){
		System.out.println(node.next == null ? "null" : node.next.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_116PopulatingNextRightPointersInEachNode A =new _116PopulatingNextRightPointersInEachNode();
		TreeLinkNode root = new TreeLinkNode(5);
		TreeLinkNode node1 = new TreeLinkNode(3);
		TreeLinkNode node2 = new TreeLinkNode(7);
		TreeLinkNode node3 = new TreeLinkNode(2);
		TreeLinkNode node4 = new TreeLinkNode(6);
		TreeLinkNode node5 = new TreeLinkNode(8);
//		TreeLinkNode node6 = new TreeLinkNode(7);
//		TreeLinkNode node7 = new TreeLinkNode(2);
//		TreeLinkNode node8 = new TreeLinkNode(5);
//		TreeLinkNode node9 = new TreeLinkNode(1);
		root.left=node1; root.right=node2; node1.left=node3; node2.left=node4;node2.right=node5;
		A.connect(root);
		print_node_next(node4);
	}

}

//question:
	//Given a binary tree
	//
	//struct TreeLinkNode {
	//  TreeLinkNode *left;
	//  TreeLinkNode *right;
	//  TreeLinkNode *next;
	//}
	//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	//
	//Initially, all next pointers are set to NULL.
	//
	//Note:
	//
	//You may only use constant extra space.
	//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
	//For example,
	//Given the following perfect binary tree,
	//     1
	//   /  \
	//  2    3
	// / \  / \
	//4  5  6  7
	//After calling your function, the tree should look like:
	//     1 -> NULL
	//   /  \
	//  2 -> 3 -> NULL
	// / \  / \
	//4->5->6->7 -> NULL