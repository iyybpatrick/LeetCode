
public class _222CountCompleteTreeNodes {

	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public int countNodes(TreeNode root) {
//		if (root == null){
//        	return 0;
//        }
//        int count_left = root.left != null ? countNodes (root.left) : 0;
//        int count_right = root.right != null ? countNodes (root.right) :0;
//        return 1 + count_left + count_right;
		
		if (root == null){
			return 0;
		}
		int height_left = height (root.left);
		int height_right = height (root.right);
		if (height_left == height_right){
			return (1<<height_left) + countNodes (root.right);
		}else{
			return (1<<height_right) + countNodes (root.left); 
		}
    }

	private int height(TreeNode right) {
		// TODO Auto-generated method stub
		if (right == null){
			return 0;
		}
		return 1+ height (right.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_222CountCompleteTreeNodes A = new _222CountCompleteTreeNodes();
		TreeNode root = null;
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(8);
		//root.left=node1; root.right = node2; node1.left=node3; node1.right=node4; node2.left=node5;
		System.out.println(A.countNodes(root));
	}

}

//question:
	//Given a complete binary tree, count the number of nodes.
	//
	//Definition of a complete binary tree from Wikipedia:
	//In a complete binary tree every level, except possibly the last, 
	//is completely filled, and all nodes in the last level are as far left as possible.
	//It can have between 1 and 2h nodes inclusive at the last level h.