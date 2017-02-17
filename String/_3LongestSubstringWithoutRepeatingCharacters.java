import java.util.*;
public class _3LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        Set<Character> set=new HashSet<Character>();
        while (j <s.length()){
        	//add character and update max
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j++));
        		max=Math.max(max, set.size());
        	}//if
        	else{
        		set.remove(s.charAt(i++));
        	}//else
        }//while
       return max; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3LongestSubstringWithoutRepeatingCharacters A=new _3LongestSubstringWithoutRepeatingCharacters();
		String test="abcabcbb";
		String test1="bbbbb";
		String test2="pwwkew";
		String test3="efabcagf";
		System.out.println(A.lengthOfLongestSubstring(test3));
	}

}

//question:
	//Given a string, find the length of the longest substring without repeating characters.
	//
	//Examples:
	//
	//Given "abcabcbb", the answer is "abc", which the length is 3.
	//
	//Given "bbbbb", the answer is "b", with the length of 1.
	//
	//Given "pwwkew", the answer is "wke", with the length of 3.
	//Note that the answer must be a substring, "pwke" is a subsequence and not a substring.