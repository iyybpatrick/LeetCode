
public class WordDictionary {

	class TrieWord{
		TrieWord []next = new TrieWord[26];
		String word ="";
	}
	private TrieWord root;
	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieWord();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieWord p = root;
        for (char c : word.toCharArray()){
        	if (p.next[c - 'a'] == null){
        		p.next[c - 'a'] = new TrieWord();
        	}
        	p = p.next[c - 'a'];
        }
        p.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    
        return BFSsearch(word.toCharArray(), 0, root);
    }
	private boolean BFSsearch(char[] word, int start, TrieWord curRoot) {
		// TODO Auto-generated method stub
		if (start == word.length){
			return !curRoot.word.equals("");
		}
		char cur = word[start];
		if (word[start] == '.'){
			for (int i = 0; i < 26; i++){
				if (curRoot.next[i] !=null){
					if (BFSsearch(word, start + 1, curRoot.next[i])){
						return true;
					}
				}//if
			}//for
		}else{
			return (curRoot.next[cur - 'a'] != null && BFSsearch(word, start + 1, curRoot.next[cur - 'a']));
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("bag");
		System.out.println(obj.search("ba."));
	}

}

//question:
	//Design a data structure that supports the following two operations:
	//
	//void addWord(word)
	//bool search(word)
	//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
	//
	//For example:
	//
	//addWord("bad")
	//addWord("dad")
	//addWord("mad")
	//search("pad") -> false
	//search("bad") -> true
	//search(".ad") -> true
	//search("b..") -> true
	//Note:
	//You may assume that all words are consist of lowercase letters a-z.