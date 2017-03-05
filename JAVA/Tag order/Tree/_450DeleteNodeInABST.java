import java.util.*;
public class _450DeleteNodeInABST {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public TreeNode deleteNode(TreeNode root, int key) {
	        if (root == null) return root;
	        if (root.val > key){
	        	root.left = deleteNode (root.left, key);
	        }//if
	        else if (root.val < key){
	        	root.right = deleteNode (root.right, key);
	        }//if
	        else{
	        	if (root.left == null){
	        		return root.right;
	        	}
	        	else if (root.right == null){
	        		return root.left;
	        	}
	        	TreeNode min_right = find_min (root.right, key);
	        	root.val = min_right.val;
	        	root.right = deleteNode (root.right, root.val);
	        }//else
	        return root;
	    }
	private TreeNode find_min(TreeNode node, int key) {
		// TODO Auto-generated method stub
		while (node.left != null){
			node = node.left;
		}
		return node;
	}
	private void print_tree (TreeNode root){
		if (root == null) return;
		Stack <TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()){
			while (cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.print(cur.val +" ");
			cur = cur.right;
		}//while
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TreeNode root = new TreeNode(5);
			TreeNode node1 = new TreeNode(3);
			TreeNode node2 = new TreeNode(6);
			TreeNode node3 = new TreeNode(2);
			TreeNode node4 = new TreeNode(4);
			TreeNode node5 = new TreeNode(7);
			root.left = node1; root.right = node2;
			node1.left = node3; node1.right = node4;
			node2.right = node5;
			_450DeleteNodeInABST A = new _450DeleteNodeInABST();
			TreeNode result = A.deleteNode(root, 3);
			A.print_tree(result);
	}

}

//question:
	//Given a root node reference of a BST and a key,
	//delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
	//
	//Basically, the deletion can be divided into two stages:
	//
	//Search for a node to remove.
	//If the node is found, delete the node.
	//Note: Time complexity should be O(height of tree).
	//
	//Example:
	//
	//root = [5,3,6,2,4,null,7]
	//key = 3
	//
	//    5
	//   / \
	//  3   6
	// / \   \
	//2   4   7
	//
	//Given key to delete is 3. So we find the node with value 3 and delete it.
	//
	//One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
	//
	//    5
	//   / \
	//  4   6
	// /     \
	//2       7
	//
	//Another valid answer is [5,2,6,null,4,null,7].
	//
	//    5
	//   / \
	//  2   6
	//   \   \
	//    4   7