import java.util.*;
public class _17LetterCombinationsOfAPhoneNumber {

	private String[] mapping = {"" ,"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations(String digits) {
		List<String> res= new LinkedList<String>();
        Combination ("", 0, res, digits);
        return res;
    }

	private void Combination(String preStr, int start, List<String> res, String digits) {
		// TODO Auto-generated method stub
		if (start == digits.length()){
			res.add(preStr);
			return;
		}
		String letter = mapping[digits.charAt(start) - '0'];
		for (int i = 0; i < letter.length(); i++){
			Combination(preStr + letter.charAt(i), start + 1, res, digits);
		}//for
	}
//	public List<String> letterCombinations(String digits) {
//	    LinkedList<String> ans = new LinkedList<String>();
//	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//	    ans.add("");
//	    for(int i =0; i<digits.length();i++){
//	        int x = Character.getNumericValue(digits.charAt(i));
//	        while(ans.peek().length()==i){
//	            String t = ans.remove();
//	            for(char s : mapping[x].toCharArray())
//	                ans.add(t+s);
//	        }
//	    }
//	    return ans;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_17LetterCombinationsOfAPhoneNumber A =new _17LetterCombinationsOfAPhoneNumber();
		String digits = "34";
		List<String> res = A.letterCombinations(digits);
		System.out.println(res);
	}

}

//question:
	//Given a digit string, return all possible letter combinations that the number could represent.
	//
	//A mapping of digit to letters (just like on the telephone buttons) is given below.
	//
	//
	//
	//Input:Digit string "23"
	//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	//Note:
	//Although the above answer is in lexicographical order, your answer could be in any order you want.
	//
