import java.util.*;
public class _205IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) return true;
        if (s.length() != t.length()) return false;
        Map <Character, Character> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
        	char curS = s.charAt(i);
        	char curT = t.charAt(i);
        	if (map.containsKey(curS)){
        		if (map.get(curS) != curT){
        			return false;
        		}
        	}else{
        		if (map.containsValue(curT)){
        			return false;
        		}else{
        			map.put(curS, curT);
        		}
        	}//else
        }//for
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_205IsomorphicStrings A =new _205IsomorphicStrings();
		String s = "apple";
		String t = "bttme"; 
		System.out.println(A.isIsomorphic(s, t));
	}

}

//question:
	//Given two strings s and t, determine if they are isomorphic.
	//
	//Two strings are isomorphic if the characters in s can be replaced to get t.
	//
	//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
	//
	//For example,
	//Given "egg", "add", return true.
	//
	//Given "foo", "bar", return false.
	//
	//Given "paper", "title", return true.
	//
	//Note:
	//You may assume both s and t have the same length.