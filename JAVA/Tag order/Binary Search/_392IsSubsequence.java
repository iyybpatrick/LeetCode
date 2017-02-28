
public class _392IsSubsequence {

	 public boolean isSubsequence(String s, String t) {
	        	if (s.length() == 0) return true;
	        	int index_s = 0;
	        	int index_t = 0;
	        	while ( index_s != s.length() && index_t != t.length()){
	        		if (s.charAt(index_s) == t.charAt(index_t)){
	        			index_s ++;
	        		}
	        		index_t++;
	        	}//while
	        	if (index_s == s.length()){
	        		return true;
	        	}else{
	        		return false;
	        	}
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_392IsSubsequence A=new _392IsSubsequence();
		String s= "1";
		String t="magtrcs1ge";
		System.out.print(A.isSubsequence(s, t));
	}

}

//questionL
	//Given a string s and a string t, check if s is subsequence of t.
	//
	//You may assume that there is only lower case English letters in both s and t.
	//t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
	//
	//A subsequence of a string is a new string which is formed from the original string 
	//by deleting some (can be none) of the characters without disturbing the relative positions 
	//of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
	//
	//Example 1:
	//s = "abc", t = "ahbgdc"
	//
	//Return true.
	//
	//Example 2:
	//s = "axc", t = "ahbgdc"
	//
	//Return false.
	//
	//Follow up:
	//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
	//and you want to check one by one to see if T has its subsequence. 
	//In this scenario, how would you change your code?