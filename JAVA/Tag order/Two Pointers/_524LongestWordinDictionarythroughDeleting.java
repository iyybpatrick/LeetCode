import java.util.*;
public class _524LongestWordinDictionarythroughDeleting {
	
	public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0) return "";
        String longest = "";
        for ( String word : d){
        	int i = 0;
        	for (char c : s.toCharArray()){
        		if (i < word.length() && c == word.charAt(i)) i++;
        	}//for
        	if (i == word.length()){
        		if (i > longest.length() || (i == longest.length() && word.compareTo(longest) < 0)){
        			longest = word;
        		}
        	}//if
        }//for d
        return longest;   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_524LongestWordinDictionarythroughDeleting A =new _524LongestWordinDictionarythroughDeleting();
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		System.out.println(A.findLongestWord(s, d));
		
	}

}

//question:
	//Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
	//
	//Example 1:
	//Input:
	//s = "abpcplea", d = ["ale","apple","monkey","plea"]
	//
	//Output: 
	//"apple"
	//Example 2:
	//Input:
	//s = "abpcplea", d = ["a","b","c"]
	//
	//Output: 
	//"a"
	//Note:
	//All the strings in the input will only contain lower-case letters.
	//The size of the dictionary won't exceed 1,000.
	//The length of all the strings in the input won't exceed 1,000.