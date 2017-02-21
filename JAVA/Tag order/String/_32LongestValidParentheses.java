import java.util.*;
public class _32LongestValidParentheses {

	public int longestValidParentheses(String s) {
		 if(s==null||s.length()<=1) return 0;
	       Stack<Integer> stack=new Stack<Integer>();
	       int len=s.length();
	       int index=0,max=0,count=0;
	       for(int i=0;i<len;i++){
	    	   if(s.charAt(i)=='('){
	    		   stack.push(i);
	    	   }//if
	    	   else if(s.charAt(i)==')'){
	    		   if(!stack.isEmpty()&&s.charAt(stack.peek())=='('){
	    			   stack.pop();
	    		   }
	    		   else{
	    			   stack.push(i);
	    		   }
	    	   }//else if
	       }//for
	       if(stack.isEmpty()) return len;
	       int high=len,cut=0;
	       while(!stack.isEmpty()){
	    	   cut=stack.peek();
	    	   stack.pop();
	    	   max=Math.max(max, high-cut-1);
	    	   high=cut;
	       }//while
	       	   max=Math.max(max, high);
	       return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_32LongestValidParentheses A=new _32LongestValidParentheses ();
		String test="()())()((())()";
		System.out.println(A.longestValidParentheses(test));
	}

}

//question:
	//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
	//
	//For "(()", the longest valid parentheses substring is "()", which has length = 2.
	//
	//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.