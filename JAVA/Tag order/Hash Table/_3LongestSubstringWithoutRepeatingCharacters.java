import java.util.*;
public class _3LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0 ) return 0;
		Set <Character> set = new HashSet<>();
		int maxLen = 0;
		int start = 0;
		int end = 0;
		while(end < s.length()){
			char cur = s.charAt(end);
			if (!set.contains(cur)){
				set.add(cur);
				maxLen = Math.max(maxLen, end - start + 1);
				end++;
			}else{
				set.remove(s.charAt(start++));
			}
		}
		return maxLen;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3LongestSubstringWithoutRepeatingCharacters A =new _3LongestSubstringWithoutRepeatingCharacters();
		String s = "pwwkew";
		System.out.println(A.lengthOfLongestSubstring(s));
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
	//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
