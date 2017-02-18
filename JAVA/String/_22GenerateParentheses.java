import java.util.*;
public class _22GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result=new LinkedList<String>();
        if(n==0) return  result;
        backtracking(result,0,0,n,"");
        return result;
    }
	private void backtracking(List<String> result, int open, int close, int max, String temp) {
		// TODO Auto-generated method stub
		if(temp.length()==max*2){
			result.add(temp);
			return;
		}//if
		if(open<max){
			backtracking(result,open+1,close,max,temp+'(');
		}//
		if(close<open){
			backtracking(result,open,close+1,max,temp+')');
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_22GenerateParentheses A=new _22GenerateParentheses();
		List<String> result=A.generateParenthesis(3);
		System.out.println(result);
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