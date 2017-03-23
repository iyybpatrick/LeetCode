import java.util.*;
public class _394DecodeString {

	public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int index = 0;
		String res = "";
		while (index < s.length()){
			if (Character.isDigit(s.charAt(index))){
				int count = 0;
				while (Character.isDigit(s.charAt(index))){
					count = count* 10 + s.charAt(index++) - '0';
				}
				countStack.push(count);
			}else if (s.charAt(index) == '['){
				resStack.push(res);
				res = "";
				index++;
			}else if (s.charAt(index) == ']'){
				StringBuilder temp = new StringBuilder(resStack.pop());
				int count = countStack.pop();
				for (int i = 0; i < count; i++){
					temp.append(res);
				}
				res = temp.toString();
				index++;
			}else{
				res += s.charAt(index++);
			}//else
		}//while
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_394DecodeString  A= new _394DecodeString ();
		String s ="3[a]2[bc]";
		System.out.println(A.decodeString(s));
	}

}

//question:
	//Given an encoded string, return it's decoded string.
	//
	//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
	//
	//You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
	//
	//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
	//
	//Examples:
	//
	//s = "3[a]2[bc]", return "aaabcbc".
	//s = "3[a2[c]]", return "accaccacc".
	//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".