
public class _44WildcardMatching {

	public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        int startp = 0, starts = 0; int match = 0, idx = -1;
        while (starts < s.length()){
        	if (startp < p.length() && (s.charAt(starts) == p.charAt(startp) || p.charAt(startp) == '?')){
        		starts++;
        		startp++;
        	}else if (startp < p.length() && p.charAt(startp) == '*'){
        		idx = startp;
        		match = starts;
        		startp++;
        	}else if (idx != -1){
        		startp = idx + 1;
        		match++;
        		starts = match;
        	}else{
        		return false;
        	}
        }//while 
        while (startp < p.length() && p.charAt(startp) == '*') startp++;
        return startp == p.length();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_44WildcardMatching A= new _44WildcardMatching ();
		String s = "aabcedc";
		String p = "a*dc";
		System.out.println(A.isMatch(s, p));
	}

}

//question:
	//Implement wildcard pattern matching with support for '?' and '*'.
	//
	//'?' Matches any single character.
	//'*' Matches any sequence of characters (including the empty sequence).
	//
	//The matching should cover the entire input string (not partial).
	//
	//The function prototype should be:
	//bool isMatch(const char *s, const char *p)
	//
	//Some examples:
	//isMatch("aa","a") → false
	//isMatch("aa","aa") → true
	//isMatch("aaa","aa") → false
	//isMatch("aa", "*") → true
	//isMatch("aa", "a*") → true
	//isMatch("ab", "?*") → true
	//isMatch("aab", "c*a*b") → false