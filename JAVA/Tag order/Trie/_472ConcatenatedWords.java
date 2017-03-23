import java.util.*;
public class _472ConcatenatedWords {
	
	class Trie{
		Trie[]next = new Trie[26];
		String word = null;
	}
	private Trie root = new Trie();
	 public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        List<String> res= new ArrayList<>();
	        if (words == null || words.length == 0 ) return res;
	        BuildTrie(words);
	        for (String word : words){
	        	findConcatenate(word, res, 0, 0);
	        }//for
	        return res;
	    }
	 
	private void findConcatenate(String word, List<String> res, int start, int count) {
		// TODO Auto-generated method stub	
		Trie p = root;
		for (int i = start; i < word.length(); i++){
			char c = word.charAt(i);
			if (p.next[c - 'a'] != null){
				p = p.next[c - 'a'];
				if (p.word != null){
					if(count == 1){
						res.add(word);
						return;
					}else{
						findConcatenate(word, res, i + 1,count + 1);	
					}
				}
			}else{ // no word in the dictionary
				return;
			}
		}//for
	}

	private void BuildTrie(String[] words) {
		// TODO Auto-generated method stub
		for (String word : words){
			Trie p = root;
			for (char c : word.toCharArray()){
				if (p.next[c - 'a'] ==null){
					p.next[c - 'a'] = new Trie();
				}
				p = p.next[c - 'a'];
			}
			p.word = word;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_472ConcatenatedWords A =new _472ConcatenatedWords();
		String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		List<String> res= A.findAllConcatenatedWordsInADict(words);
		System.out.println(res);
	}

}

//question:
	//Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
	//
	//A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
	//
	//Example:
	//Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
	//
	//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
	//
	//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
	// "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
	//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
	//Note:
	//The number of elements of the given array will not exceed 10,000
	//The length sum of elements in the given array will not exceed 600,000.
	//All the input string will only include lower case letters.
	//The returned elements order does not matter.
