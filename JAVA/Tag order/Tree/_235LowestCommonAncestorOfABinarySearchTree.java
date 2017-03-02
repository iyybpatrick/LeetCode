
import java.util.*;
public class _235LowestCommonAncestorOfABinarySearchTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val){
        	return lowestCommonAncestor (root.left, p, q);
        }else if ( root.val < p.val && root.val < q.val){
        	return lowestCommonAncestor (root.right, p, q);
        }else{
        	return root;
        }
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
		_235LowestCommonAncestorOfABinarySearchTree A =new _235LowestCommonAncestorOfABinarySearchTree();
		System.out.println(A.lowestCommonAncestor(root, node1, node5).val);
	}

}

//question:
	//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
	//
	//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two 
	//nodes v and w as the lowest node in T that has both v and w as 
	//descendants (where we allow a node to be a descendant of itself).”
	//
	//        _______6______
	//       /              \
	//    ___2__          ___8__
	//   /      \        /      \
	//   0      _4       7       9
	//         /  \
	//         3   5
	//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. 
	//Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of 
	//itself according to the LCA definition.