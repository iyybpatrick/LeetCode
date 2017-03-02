import java.util.*;

public class _226InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (!stack.isEmpty()){
        	TreeNode cur = stack.pop();
        	TreeNode left = cur.left;
        	cur.left = cur.right;
        	cur.right = left;
        	if (cur.left != null) {
        		invertTree (cur.left);
        	}
        	if (cur.right != null){
        		invertTree (cur.right);
        	}
        }//while
        return root;
    }
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public void print (TreeNode root){
		Deque<TreeNode> queue =new LinkedList<>();
		TreeNode cur =null;
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i=0; i<size; i++){
				cur = queue.poll();
				System.out.print(cur.val +" ");
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}//for
			System.out.println();
		}//while
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_226InvertBinaryTree A = new _226InvertBinaryTree();
		TreeNode root =new TreeNode (7);
		TreeNode node1 = new TreeNode (4);
		TreeNode node2 = new TreeNode (2);
		TreeNode node3 = new TreeNode (3);
		TreeNode node4 = new TreeNode (10);
		TreeNode node5 = new TreeNode (9);
		TreeNode node6 = new TreeNode (14);
		root.left = node1; root.right = node4;
		node1.left = node2; node2.right = node3;
		node4.left = node5; node4.right = node6;
		TreeNode New = A.invertTree(root);
		A.print(New);
	}

}

//question:
//Invert a binary tree.
//
//4
///   \
//2     7
/// \   / \
//1   3 6   9
//to
//4
///   \
//7     2
/// \   / \
//9   6 3   1
//Trivia:
//This problem was inspired by this original tweet by Max Howell:
//Google: 90% of our engineers use the software you wrote (Homebrew), 
//but you can’t invert a binary tree on a whiteboard so fuck off.
