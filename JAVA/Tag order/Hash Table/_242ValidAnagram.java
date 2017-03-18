import java.util.*;
public class _242ValidAnagram {

	public boolean isAnagram(String s, String t) {
       if (s == null && t== null) return false;
       if (s.length() != t.length()) return false;
       Map <Character, Integer> map = new HashMap<>();
       for (char c : s.toCharArray()){
    	   map.put(c, map.getOrDefault(c, 0) + 1);
       }
       for (int i = 0; i < t.length(); i++){
    	   char cur = t.charAt(i);
    	   if (map.containsKey(cur)){
    		   int count = map.get(cur);
    		   if (count == 1){
    			   map.remove(cur);
    		   }else{
    			   map.put(cur, count - 1);
    		   }//else
    	   }else{
    		   return false;
    	   }
       }//for
       return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_242ValidAnagram A =new _242ValidAnagram();
		String s= "helloworld";
		String t= "werldlloho";
		System.out.println(A.isAnagram(s, t));
	}

}

//question:
	//Given two strings s and t, write a function to determine if t is an anagram of s.
	//
	//For example,
	//s = "anagram", t = "nagaram", return true.
	//s = "rat", t = "car", return false.
	//
	//Note:
	//You may assume the string contains only lowercase alphabets.
	//
	//Follow up:
	//What if the inputs contain unicode characters? How would you adapt your solution to such case?