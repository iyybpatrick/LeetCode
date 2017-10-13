package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
public class _211AddAndSearchWord_DatastructureDesign {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        char val;
        boolean isWord;
        TrieNode(char val) {
            this.val = val;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public _211AddAndSearchWord_DatastructureDesign() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c -'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return true;
        return searchWord(word, 0, root);
    }

    public boolean searchWord(String word, int start, TrieNode root) {
        if (start == word.length()) return root.isWord;
        TrieNode cur = root;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchWord(word, i + 1, cur.children[j])) return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] != null) {
                    return searchWord(word, i + 1, cur.children[c - 'a']);
                } else {
                    return false;
                }
            }
        } // for i
        return false;
    }

    public static void main(String[] args){
        _211AddAndSearchWord_DatastructureDesign A =new _211AddAndSearchWord_DatastructureDesign();
        A.addWord("a");
        A.addWord("a");
        //A.addWord("def");
        //A.addWord("mma");
        //System.out.print(A.search("..bbc"));
        //System.out.println(A.search("."));
        //System.out.println(A.search("a"));
        //System.out.println(A.search("a"));
        //System.out.println(A.search("aa"));
        //System.out.println(A.search("a"));
        System.out.println(A.search(".a"));
        //System.out.println(A.search("a."));
    }
}
