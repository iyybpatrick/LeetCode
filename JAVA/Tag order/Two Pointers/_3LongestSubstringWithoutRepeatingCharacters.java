import java.util.*;
public class _3LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int MaxLen = 1;
		int j = 0;
		for (int i = 0 ; i < s.length(); i++){
			if (map.containsKey(s.charAt(i))){
				 j = Math.max(map.get(s.charAt(i)) + 1, j); // the reason why we need Math.max is because pointer j should only go right.
				 											//when the string is "abba", it may go left.
			}
			map.put(s.charAt(i), i);
			MaxLen = Math.max(MaxLen, i - j + 1);
		}
		return MaxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3LongestSubstringWithoutRepeatingCharacters A =new _3LongestSubstringWithoutRepeatingCharacters();
		String s = "abba";
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