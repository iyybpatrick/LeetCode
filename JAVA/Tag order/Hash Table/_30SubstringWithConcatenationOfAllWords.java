import java.util.*;
public class _30SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || words == null || s.length() == 0 || words.length == 0) return res;
		Map <String, Integer> map = new HashMap<>();
		for (String word : words){
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		int wordLen = words[0].length();
		int wordCount = words.length;
		int sLen = s.length();
		for (int i = 0; i < (sLen - wordLen * wordCount); i++){
			Map<String, Integer> copy = new HashMap<>(map);
			for (int j = 0; j < wordCount; j++){
				String word = s.substring(i + j * wordLen, i + j * wordLen +wordLen);
				if (copy.containsKey(word)){
					int count = copy.get(word);
					if (count == 1){
						copy.remove(word);
					}else{
						copy.put(word, count - 1);
					}
				}else break;
			}//for j 
			if(copy.isEmpty()){
				res.add(i);
			}
		}//for i 
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 _30SubstringWithConcatenationOfAllWords  A =new  _30SubstringWithConcatenationOfAllWords ();
		 String s = "barfoothefoobarman";
		 String[] words = {"bar", "foo"};
		 List<Integer> res = A.findSubstring(s, words);
		 System.out.println(res);
	}

}

//question:
	//You are given a string, s, and a list of words, words, that are all of the same length.
	//Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and
	//without any intervening characters.
	//
	//For example, given:
	//s: "barfoothefoobarman"
	//words: ["foo", "bar"]
	//
	//You should return the indices: [0,9].
	//(order does not matter).