package design;

/**
 * Created by YuebinYang on 10/13/17.
 */
public class _208ImplementTrie_PrefixTree {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            char val;
            boolean isWord;
            TrieNode(char val){
                this.val = val;
            }
        }
        TrieNode root;
        /** Initialize your data structure here. */
        public _208ImplementTrie_PrefixTree() {
            root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            } // for char c
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] != null) {
                    cur = cur.children[c - 'a'];
                } else {
                    return false;
                }
            } // for char c
            if (cur.isWord) return true;
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] != null) {
                    cur = cur.children[c - 'a'];
                } else return false;
            }
            return true;

        }

        public static void main(String[] args){
            _208ImplementTrie_PrefixTree A = new _208ImplementTrie_PrefixTree();
            A.insert("hello");
            A.insert("helloa");
            System.out.print(A.search("hello"));
            System.out.print(A.search("helloab"));
            System.out.print(A.startsWith("hel"));
        }
}
