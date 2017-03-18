import java.util.*;
public class _290WordPattern {

	// method one
//	public boolean wordPattern(String pattern, String str) {
//        if (pattern == null) return false;
//        Map<Character, String> map = new HashMap<>();
//        int wordstart = 0;
//        int wordEnd = 0;
//        for (int i = 0; i < pattern.length(); i++){
//        	if (wordstart == str.length()) return false;
//       
//        	while (str.charAt(wordstart) == ' ') wordstart++;
//    		wordEnd = wordstart;
//    		while (wordEnd < str.length() && str.charAt(wordEnd) != ' ') wordEnd++;
//    		String word = str.substring(wordstart, wordEnd);
//    		wordstart = wordEnd;
//        	if (!map.containsKey(pattern.charAt(i))){
//        		if (map.containsValue(word)){
//        			return false;
//        		}else{
//        			map.put(pattern.charAt(i), word);
//        		}
//        	}else{
//        		if (!map.get(pattern.charAt(i)).equals(word)){
//        			return false;
//        		}
//        	}//else
//        }//for
//        if (wordEnd != str.length()) return false;
//        return true;
//    }
	
	// method two
	public boolean wordPattern(String pattern, String str) {
		String []words = str.split(" ");
		if (words.length != pattern.length()) return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++){
			if (!map.containsKey(pattern.charAt(i))){
				if (!map.containsValue(words[i])){
					map.put(pattern.charAt(i), words[i]);
				}else{
					return false;
				}
			}else{
				if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_290WordPattern A =new _290WordPattern();
		String pattern = "abba";
		String str = "dog c c dog";
		System.out.println(A.wordPattern(pattern, str));
	}

}

//question:
	//Given a pattern and a string str, find if str follows the same pattern.
	//
	//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
	//
	//Examples:
	//pattern = "abba", str = "dog cat cat dog" should return true.
	//pattern = "abba", str = "dog cat cat fish" should return false.
	//pattern = "aaaa", str = "dog cat cat dog" should return false.
	//pattern = "abba", str = "dog dog dog dog" should return false.
	//Notes:
	//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
