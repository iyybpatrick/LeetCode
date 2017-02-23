import java.util.*;


public class _103BinaryTreeZigzagLevelOrderTraversal {

	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result= new LinkedList <List<Integer>>();
        if (root ==null ) return result;
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
        	List<Integer> level =new ArrayList<>();
        	while (!stack1.isEmpty()){
        		TreeNode temp = stack1.pop();
        		level.add(temp.val);
        		if (temp.left != null) stack2.push(temp.left);
        		if (temp.right != null) stack2.push(temp.right);
        	}//while
        	result.add(level);
        	level= new ArrayList<Integer>();
        	
        	while(!stack2.isEmpty()){
        		TreeNode temp = stack2.pop();
        		level.add(temp.val);
        		if (temp.right != null) stack1.push(temp.right);
        		if (temp.left != null) stack1.push(temp.left);
        	}//while
        	if (!level.isEmpty()){
        		result.add(level);
        	}//if
        }//while
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =new TreeNode(3);
		TreeNode node1 =new TreeNode(9);
		TreeNode node2 =new TreeNode(5);
		TreeNode node3 =new TreeNode(6);
		TreeNode node4 =new TreeNode(7);
		TreeNode node5 =new TreeNode(8);
		TreeNode node6 =new TreeNode(9);
		root.left=node1; node1.left=node2; node2.right=node3; node3.right=node4; root.right=node5; node5.left=node6;
		_103BinaryTreeZigzagLevelOrderTraversal A=new _103BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result= A.zigzagLevelOrder(root);
		System.out.println(result);
	}

}
