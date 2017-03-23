
public class Trie {
	
	class TrieNode{
		TrieNode []next = new TrieNode[26];
		String word;
	}
	
	private TrieNode root;
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()){
        	if (p.next[c - 'a'] == null){
        		p.next[c - 'a'] = new TrieNode();
        	}
        	p = p.next[c - 'a'];
        }
        p.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()){
        	if (p.next[c - 'a'] == null){
        		return false;
        	}else{
        		p = p.next[c - 'a'];
        	}
        }//for
        if (p.word != null) return true;
        else return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()){
        	if (p.next[c - 'a'] == null){
        		return false;
        	}else{
        		p = p.next[c - 'a'];
        	}
        }//for
        return true;
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie obj = new Trie();
		obj.insert("this");
		System.out.println(obj.search("th"));
		obj.insert("th");
		System.out.println(obj.search("th"));
		System.out.println(obj.startsWith("th"));
		System.out.println(obj.search("this"));
	}

}

//question:
	//Implement a trie with insert, search, and startsWith methods.
