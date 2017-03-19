import java.util.*;
public class _389FindTheDifference {

	// map method
//	public char findTheDifference(String s, String t) {
//        if (s == null && t.length() == 1) return t.charAt(0);
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()){
//        	map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for ( char c : t.toCharArray()){
//        	if (map.containsKey(c) && map.get(c) > 0){
//        		map.put(c, map.get(c) - 1);
//        	}else{
//        		return c;
//        	}
//        }
//        return 'x';
//    }
	public char findTheDifference(String s, String t) {
		int [] characters = new int[26];
		for (char c : s.toCharArray()){
			characters[c - 'a']++;
		}
		for (char c : t.toCharArray()){
			if (characters[c - 'a'] == 0){
				return c;
			}else{
				characters[c - 'a']--;
			}
		}
		return 'x';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_389FindTheDifference A =new _389FindTheDifference();
		String s = "abce";
		String t = "ebcad";
		System.out.println(A.findTheDifference(s, t));
		//System.out.println('c'-'a');
	}

}

//question:
	//Given two strings s and t which consist of only lowercase letters.
	//
	//String t is generated by random shuffling string s and then add one more letter at a random position.
	//
	//Find the letter that was added in t.
	//
	//Example:
	//
	//Input:
	//s = "abcd"
	//t = "abcde"
	//
	//Output:
	//e
	//
	//Explanation:
	//'e' is the letter that was added.