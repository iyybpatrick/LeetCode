import java.util.*;
public class _20ValidParentheses {

	public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        int cur = 1;
        stack.push(s.charAt(0));
        while (cur < s.length()){
        	char c = s.charAt(cur);
        	if (c == '(' || c == '[' || c =='{'){
        		stack.push(c);
        		cur++;
        	}else if (c =='}'){
        		if (!stack.isEmpty() && stack.peek() == '{'){
        			stack.pop();
        			cur++;
        		}else{
        			return false;
        		}
        	}else if (c ==']'){
        		if (!stack.isEmpty() && stack.peek() == '['){
        			stack.pop();
        			cur++;
        		}else{
        			return false;
        		}
        	}else if (c ==')'){
        		if (!stack.isEmpty() && stack.peek() == '('){
        			stack.pop();
        			cur++;
        		}else{
        			return false;
        		}
    		}else{
    			return false;
        	}
        }
        if (stack.isEmpty()){
        	return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_20ValidParentheses A= new _20ValidParentheses();
		String s = "";
		System.out.println(A.isValid(s));
	}

}

//question:
	//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	//
	//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
