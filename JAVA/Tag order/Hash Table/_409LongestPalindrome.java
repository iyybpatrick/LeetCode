import java.util.*;
public class _409LongestPalindrome {

	public int longestPalindrome(String s) {
        if (s == null) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0;i < s.length(); i++){
        	if (set.contains(s.charAt(i))){
        		set.remove(s.charAt(i));
        		count++;
        	}else{
        		set.add(s.charAt(i));
        	}
        }//for
        if (!set.isEmpty()) return (count *2 + 1);
        return count * 2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
	//
	//This is case sensitive, for example "Aa" is not considered a palindrome here.
	//
	//Note:
	//Assume the length of given string will not exceed 1,010.

