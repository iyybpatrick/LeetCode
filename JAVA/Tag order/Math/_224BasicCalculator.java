import java.util.*;
public class _224BasicCalculator {

	public int calculate(String s) {
        if (s == null) return 0;
        int number = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int index = 0; index < s.length(); index++){
        	char cur = s.charAt(index);
        	if (Character.isDigit(cur)){
        		number = number * 10 + (int)(cur - '0');
        	}else if (cur == '+'){
        		res += sign * number;
        		sign = 1;
        		number = 0;
        	}else if (cur == '-'){
        		res += sign * number;
        		sign = -1;
        		number = 0;
        	}else if (cur == '('){
        		stack.push(res);
        		stack.push(sign);
        		res = 0;
        		sign = 1;
        	}else if (cur == ')'){
        		res += number * sign;
        		res *= stack.pop();
        		res += stack.pop();
        		number = 0;
        	}      	
        }//for
        if (number != 0)
    		res += sign * number;
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_224BasicCalculator A =new _224BasicCalculator();
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(A.calculate(s));
	}

}

//question:
	//Implement a basic calculator to evaluate a simple expression string.
	//
	//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
	//
	//You may assume that the given expression is always valid.
	//
	//Some examples:
	//"1 + 1" = 2
	//" 2-1 + 2 " = 3
	//"(1+(4+5+2)-3)+(6+8)" = 23
	//Note: Do not use the eval built-in library function.