import java.util.*;
public class _22GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
		List<String> res= new ArrayList<>();
        if (n == 0) return res;
        
        generateParen (n - 1, n, res, "(");
        return res;
    }

	private void generateParen(int right, int left, List<String> res, String path) {
		// TODO Auto-generated method stub
		if ( right == 0 && left == 0){
			res.add(path);
		}
		if (right != 0){
			generateParen(right - 1, left, res, path + "(");
		}
		if (left != 0 && left > right){
			generateParen(right, left - 1, res, path + ")");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_22GenerateParentheses A= new _22GenerateParentheses();
		List<String> res = A.generateParenthesis(3);
		System.out.println(res);
	}

}

//question:
	//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	//
	//For example, given n = 3, a solution set is:
	//
	//[
	//  "((()))",
	//  "(()())",
	//  "(())()",
	//  "()(())",
	//  "()()()"
	//]