import java.util.*;
public class _20ValidParentheses {

	public boolean isValid(String s) {
        if(s.length()<=1) return false;
        Stack<Character> stack=new Stack<Character>();
        int index=0;
        while(index<s.length()){
        	if(s.charAt(index)=='('||s.charAt(index)=='['||s.charAt(index)=='{'){
        		stack.push(s.charAt(index++));
        	}//if
        	else if(s.charAt(index)==')'&&!stack.empty()&&stack.peek()=='('){
        		stack.pop();
        		index++;
        	}
        	else if(s.charAt(index)==']'&&!stack.empty()&&stack.peek()=='['){
        		stack.pop();
        		index++;
        	}
        	else if(s.charAt(index)=='}'&&!stack.empty()&&stack.peek()=='{'){
        		stack.pop();
        		index++;
        	}
        	else {return false;}
     
        }//while
        if(stack.empty()) return true;
    	else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_20ValidParentheses  A=new _20ValidParentheses ();
		String a="[[[]{(()){}}]]";
		System.out.println(A.isValid(a));
	}

}

//question:
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.
//
//The brackets must close in the correct order, 
//"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

