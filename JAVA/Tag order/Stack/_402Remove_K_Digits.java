import java.util.*;
public class _402Remove_K_Digits {

	public String removeKdigits(String num, int k) {
        if (num ==null) return "0";
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()){
        	while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
        		stack.pop();
        		k--;
        	}
        	stack.push(num.charAt(i++));
        }//while
        
        while ( k > 0){
        	stack.pop();
        	k--;
        }
        StringBuilder temp = new StringBuilder();
        while(!stack.isEmpty()){
        	temp.append(stack.pop());
        }
        temp.reverse();
        System.out.println(temp.toString());
        while (temp.length() != 0 && temp.charAt(0) == '0'){
        	temp.deleteCharAt(0);
        }
        return temp.length() == 0 ? "0" : temp.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_402Remove_K_Digits A =new _402Remove_K_Digits();
		String num = "10023";
		System.out.println(A.removeKdigits(num, 1));
	}

}

//question:
	//Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
	//
	//Note:
	//The length of num is less than 10002 and will be ≥ k.
	//The given num does not contain any leading zero.
	//Example 1:
	//
	//Input: num = "1432219", k = 3
	//Output: "1219"
	//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
	//Example 2:
	//
	//Input: num = "10200", k = 1
	//Output: "200"
	//Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
	//Example 3:
	//
	//Input: num = "10", k = 2
	//Output: "0"
	//Explanation: Remove all the digits from the number and it is left with nothing which is 0.
