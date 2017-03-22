import java.util.*;
public class _212WordSearchII {

	// dfs + backtracking, time exceeds.
//	public List<String> findWords(char[][] board, String[] words) {
//		List<String> res = new LinkedList<>();
//        if (board == null || board.length == 0 || board[0].length == 0) return res;
//        Set<String> set = new HashSet();
//        for (String str : words){
//        	set.add(str);
//        }
//        for (int i = 0; i < board.length; i++){
//        	for (int j = 0; j < board[0].length; j++){
//        		for (int k = 0; k < words.length; k++){
//        			if (set.contains(words[k])){
//        				if (DFS(i, j, board.length, board[0].length, board, words[k], 0)){
//        					res.add(words[k]);
//        					set.remove(words[k]);
//        				}
//        			}
//        		}//for k
//        	}//for j
//        }//for i
//        return res;
//    }
//	private boolean DFS(int i, int j, int maxi, int maxj, char[][] board, String word, int idx ) {
//		// TODO Auto-generated method stub
//		if (idx == word.length()){
//			return true;
//		}
//		if (i < 0 || j < 0 || i >= maxi || j >= maxj) return false;
//		if (word.charAt(idx) != board[i][j]) return false;
//		board[i][j] ^=256;
//		boolean judge = DFS(i + 1, j, maxi, maxj, board, word, idx + 1)
//						|| DFS(i - 1, j, maxi, maxj, board, word, idx + 1)
//						|| DFS(i, j + 1, maxi, maxj, board, word, idx + 1)
//						|| DFS(i, j - 1, maxi, maxj, board, word, idx + 1);
//		board[i][j] ^=256;
//		return judge;
//	}
	
	class TrieNode{
		TrieNode []next = new TrieNode[26];
		String word;
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new LinkedList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				DFS(board, i, j, root, res);
			}//for j
		}//for i
		return res;
	}
	private void DFS(char[][] board, int i, int j, TrieNode root, List<String> res) {
		// TODO Auto-generated method stub
		char c = board[i][j];
		TrieNode p = root;
		if (c == '#' || p.next[c - 'a'] == null) return;
		
		p = p.next[c - 'a'];
		if (p.word != null){
			res.add(p.word);
			p.word = null;
		}
		board[i][j] = '#';
		if (i > 0) DFS(board, i - 1, j, p, res);
		if (j > 0) DFS(board, i, j - 1, p, res);
		if (i < board.length - 1) DFS(board, i + 1, j, p, res);
		if (j < board[0].length - 1) DFS(board, i , j + 1, p, res);
		board[i][j] = c;
	}
	private TrieNode buildTrie(String[] words) {
		// TODO Auto-generated method stub
		TrieNode root = new TrieNode();
		for (String word : words){
			TrieNode p = root;
			for (char c : word.toCharArray()){
				int idx = c - 'a';
				if (p.next[idx] == null){
					p.next[idx] = new TrieNode();
				}
				p = p.next[idx];
			}//for char c
			p.word = word;
		}//for word
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_212WordSearchII  A= new _212WordSearchII ();
		char[][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}, {'i','f','l','v'}};
		String []words = {"oath","pea","eat","rain"};
		//char[][]board = {{'a'}};
		//String []words = {"a","a"};
		List<String> res = A.findWords(board, words);
		System.out.println(res);
		
	}

}

//question:
	//Given a 2D board and a list of words from the dictionary, find all words in the board.
	//
	//Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
	//
	//For example,
	//Given words = ["oath","pea","eat","rain"] and board =
	//
	//[
	//  ['o','a','a','n'],
	//  ['e','t','a','e'],
	//  ['i','h','k','r'],
	//  ['i','f','l','v']
	//]
	//Return ["eat","oath"].
