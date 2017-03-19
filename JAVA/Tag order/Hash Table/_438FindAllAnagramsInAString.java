import java.util.*;
public class _438FindAllAnagramsInAString {

	//method one
//	public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        if (s == null) return res;
//        char[] temp = p.toCharArray();
//        Arrays.sort(temp);
//        String pat = String.valueOf(temp);
//        int patLen = pat.length();
//        for (int i = 0; i <= (s.length() - patLen); i++){
//        	String sub = s.substring(i, i + patLen);
//        	char[] temp1 = sub.toCharArray();
//            Arrays.sort(temp1);
//            String sorted = String.valueOf(temp1);
//            if (pat.equals(sorted)){
//            	res.add(i);
//            }
//        }//for
//        return res;
//    }
	


	public List<Integer> findAnagrams(String s, String p) {
	    List<Integer> res = new ArrayList<>();
	    int []hash = new int[256];
	    for (char c : p.toCharArray()){
	    	hash[c]++;
	    }
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()){
	    	if (hash[s.charAt(right++)]-- >= 1) {
	    		count--;	
	    	}
	    	if (count == 0) res.add(left);
	    	if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_438FindAllAnagramsInAString A =new _438FindAllAnagramsInAString();
		String p = "ab";
		String s = "abcdab";
		List<Integer> res = A.findAnagrams(s, p);
		System.out.println(res);
		int []test = {1,2,3};
		int index = 1; 
		if (test[index++]-- >= 2) {
			
			System.out.println(test[0] +" "+ test[1]+" "+test[2]+ " "+index);
		}
	}

}

//question:
	//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
	//
	//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
	//
	//The order of output does not matter.
	//
	//Example 1:
	//
	//Input:
	//s: "cbaebabacd" p: "abc"
	//
	//Output:
	//[0, 6]
	//
	//Explanation:
	//The substring with start index = 0 is "cba", which is an anagram of "abc".
	//The substring with start index = 6 is "bac", which is an anagram of "abc".
	//Example 2:
	//
	//Input:
	//s: "abab" p: "ab"
	//
	//Output:
	//[0, 1, 2]
	//
	//Explanation:
	//The substring with start index = 0 is "ab", which is an anagram of "ab".
	//The substring with start index = 1 is "ba", which is an anagram of "ab".
	//The substring with start index = 2 is "ab", which is an anagram of "ab".