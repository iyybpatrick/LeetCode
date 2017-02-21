import java.util.*;


public class _17LetterCombinationsOfAPhoneNumber {
	
	private String[] key={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};	
	public List<String> letterCombinations(String digits) {
		List<String> result=new LinkedList<String>();
		if(digits.length()==0) return result;
		result.add("");
		for(int i=0;i<digits.length();i++){
			result=digit_combine(key[digits.charAt(i)-'0'],result);
		}//for
		return result;
    }
	private List<String> digit_combine(String ToAdd, List<String> pre_result) {
		// TODO Auto-generated method stub
		List<String> new_result = new LinkedList<String>();
			for(int j=0;j<ToAdd.length();j++){
				for(String s: pre_result){
				new_result.add(s+ToAdd.charAt(j));
				}//for
		}//for
		return new_result;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_17LetterCombinationsOfAPhoneNumber A=new _17LetterCombinationsOfAPhoneNumber();
		String digit="12";
		List<String> result=A.letterCombinations(digit);
		System.out.println(result);
	}

}
