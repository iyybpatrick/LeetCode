import java.util.*;
public class _30SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
        if (s == null) return res;
        int len = words[0].length();
        int WordCount = words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //System.out.println(s.length() - len * WordCount);
        for (int i = 0 ; i <= (s.length() - len * WordCount); i++){
        	Map<String, Integer> copy = new HashMap<>(map);
        	for (int j = 0 ;  j < WordCount; j++){
        		String sub = s.substring(i + j * len, i + j * len + len);
        		if (copy.containsKey(sub)){
        			int count = copy.get(sub);
        			if (count == 1){
        				copy.remove(sub);
        			}else{
        				copy.put(sub, count - 1);
        			}//else
        			if (copy.isEmpty()){
        				res.add(i);
        				break;
        			}
        		}//if
        		else break; // not match, start searching with a new character
        	}//for j
        }//for i
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_30SubstringWithConcatenationOfAllWords  A =new _30SubstringWithConcatenationOfAllWords ();
		String s = "fooookbarfoo";
		String []words = {"bar", "foo", "ook"};
		List<Integer> res=  A.findSubstring(s, words);
		System.out.println(res);
	}

}

//question:
	//You are given a string, s, and a list of words, words, that are all of the same length. 
	//Find all starting indices of substring(s) in s that is a concatenation of each word in words 
	//exactly once and without any intervening characters.
	//
	//For example, given:
	//s: "barfoothefoobarman"
	//words: ["foo", "bar"]
	//
	//You should return the indices: [0,9].
	//(order does not matter).