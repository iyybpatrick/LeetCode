import java.util.*;
public class _76MinimumWindowSubstring {

	public String minWindow(String s, String t) {
	        if (s == null || t == null || s.length() < t.length()) return "";
	        Map <Character, Integer> map = new HashMap<>();
	        for (char c : t.toCharArray()){
	        	map.put(c, map.getOrDefault(c, 0) + 1);
	        }
	        int minLen = s.length() + 1;
	        int left= 0;
	        int right = 0;
	        int count = 0;
	        int minLeft = 0;
	        for (; right < s.length(); right++){
	        	char cur = s.charAt(right);
	        	if (!map.containsKey(cur)) continue;
	        	map.put(cur, map.get(cur) - 1);
	        	if (map.get(cur) >= 0){
	        		count++;
	        	}
	        	while (count == t.length()){
	        		if (minLen > (right - left +1)){
	        			minLen = right - left + 1;
	        			minLeft = left;
	        		}
	        		char le_cur = s.charAt(left);
	        		if (map.containsKey(le_cur)){
	        			map.put(le_cur, map.get(le_cur) + 1);
	        			if (map.get(le_cur) > 0){
	        				count--;
	        			}
	        		}//if
	        		left++;
	        	}//while
	        	
	        }//for
	        return minLen == s.length() + 1 ? "" :s.substring(minLeft, minLeft + minLen);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_76MinimumWindowSubstring  A =new _76MinimumWindowSubstring  ();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(A.minWindow(s, t));
	}

}

//question:
	//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	//
	//For example,
	//S = "ADOBECODEBANC"
	//T = "ABC"
	//Minimum window is "BANC".
