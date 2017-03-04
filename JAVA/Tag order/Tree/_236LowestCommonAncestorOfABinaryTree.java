
import java.util.*;
public class _236LowestCommonAncestorOfABinaryTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	//  information passes from bottom to top, when come to one node, it's passing information relies on
	//  the information of two children.
	//  if both of left and right are not empty, it means this is the nearest parent of p and q.
	//  if only one side of children is not empty, it tells it's parent that the target node is here.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor (root.left, p, q);
		TreeNode right = lowestCommonAncestor (root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		
		return left == null ? right : left;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}

//question:
	//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	//
	//According to the definition of LCA on Wikipedia: “The lowest common ancestor 
	//is defined between two nodes v and w as the lowest node in T that has both v and w as 
	//descendants (where we allow a node to be a descendant of itself).”
	//
	//        _______3______
	//       /              \
	//    ___5__          ___1__
	//   /      \        /      \
	//   6      _2       0       8
	//         /  \
	//         7   4
	//For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
	//Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of 
	//itself according to the LCA definition.