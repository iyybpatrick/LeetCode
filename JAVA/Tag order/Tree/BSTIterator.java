import java.util.*;

public class BSTIterator {

	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	private Stack<TreeNode> stack =new Stack<>();
	private TreeNode cur=null;
	 public BSTIterator(TreeNode root) {
		 	if (root == null) return;
	       stack.push(root);
	       cur = root.left;
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return cur != null || !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        	while (cur !=null){
	        		stack.push(cur);
	        		cur = cur.left;
	        	}//while
	        	cur = stack.pop();
	        	int val = cur.val;
	        	cur = cur.right;
	        	return val;
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
		BSTIterator i = new BSTIterator(root);
		List<Integer> result = new LinkedList<>();
		
		while (i.hasNext()){
			//result.add(i.next());
			System.out.println(i.next());
		}
		//System.out.println(result);
	}

}
