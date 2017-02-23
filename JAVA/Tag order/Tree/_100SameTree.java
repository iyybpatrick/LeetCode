import java.util.*;

public class _100SameTree {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Stack<TreeNode> stackp= new Stack<TreeNode>();
        Stack<TreeNode> stackq= new Stack<TreeNode>();
        stackp.push(p);
        stackq.push(q);
        while (!stackp.isEmpty() && !stackq.isEmpty()){
        	TreeNode tmp_p= stackp.pop();
        	TreeNode tmp_q= stackq.pop();
        	if (tmp_p.val != tmp_q.val) return false;
        	// search for left child.
        	if (tmp_p.left != null && tmp_q.left != null){
        		stackp.push(tmp_p.left);
        		stackq.push(tmp_q.left);
        	}//if
        	else if (tmp_p.left == null && tmp_q.left == null){
	
        	}//else if
        	else return false;
        	
        	//search for right child.
        	if(tmp_p.right != null && tmp_q.right != null){
        		stackp.push(tmp_p.right);
        		stackq.push(tmp_q.right);
        	}//if
        	else if (tmp_p.right == null && tmp_q.right ==null){
        		
        	}//else if
        	else return false;
        	
        }//while
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_100SameTree A= new _100SameTree();
		TreeNode node1=new TreeNode (1);
		TreeNode node2=new TreeNode (1);
		TreeNode node3=new TreeNode (6);
		TreeNode node4=new TreeNode (6);
		node1.right=node3;
		node2.right=node4;
		System.out.println(A.isSameTree(node1, node2));
	}

}

//question:
	//Given two binary trees, write a function to check if they are equal or not.
	//
	//Two binary trees are considered equal if they are structurally identical and the nodes 
	//have the same value.

