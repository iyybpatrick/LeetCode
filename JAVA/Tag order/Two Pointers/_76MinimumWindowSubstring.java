import java.util.*;
public class _76MinimumWindowSubstring {

	public String minWindow(String s, String t) {
        if (s == "" || t == "") return "";
        int []count = new int[128];
        for (int i = 0; i < t.length(); i++){
        	count[(int)t.charAt(i)]++;
        }
        int Remain = t.length();
        int minLen = Integer.MAX_VALUE;
        int minIdx = 0;
        int start = 0;
        int end = 0;
        
        while (end < s.length()){
        	if (count[s.charAt(end)] > 0){
        		Remain--;
        	}
        	count[s.charAt(end)] --;
        	end++;
        	while (Remain == 0){
        		if (minLen > end - start){
        			minLen = end - start;
        			minIdx = start;
        		}
        		count[s.charAt(start)]++;
        		if (count[s.charAt(start)] > 0){
        			Remain++;
        		}
        		start++;
        	}//while
        }//while
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minLen);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC";
		String t = "ABC";
		_76MinimumWindowSubstring A =new _76MinimumWindowSubstring();
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