import java.util.*;
public class _212WordSearchII {

	class Trie {
		Trie []next = new Trie[26];
		String word;
	}
	private Trie root = new Trie();
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new LinkedList<>();
		
		if (board == null || board.length == 0 || board[0].length == 0) return res;
		BuildTrie(words);
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				DFS(board, res, i, j, root);
			}
		}
		return res;
	}
	private void DFS(char[][] board, List<String> res, int i, int j, Trie cur) {
		// TODO Auto-generated method stub
		char c = board[i][j];
		Trie p = cur;
		
		if (c == '#' || p.next[c - 'a'] == null) return;
		p = p.next[c - 'a'];
		if (p.word != null){
			res.add(p.word);
			p.word = null;
		}
		board[i][j] = '#';
		if (i > 0) DFS(board, res, i - 1, j, p);
		if (j > 0) DFS(board, res, i, j - 1, p);
		if (i < board.length - 1) DFS(board, res, i + 1, j, p);
		if (j < board[0].length - 1) DFS(board, res, i, j + 1, p);
		board[i][j] = c;
		
	}
	private void BuildTrie(String[] words) {
		// TODO Auto-generated method stub
		for (String word : words){
			Trie p = root;
			for (char c :  word.toCharArray()){
				if (p.next[c - 'a'] == null){
					p.next[c - 'a'] = new Trie();
				}
				p = p.next[c - 'a'];
			}
			p.word = word;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_212WordSearchII A =new _212WordSearchII();
		char[][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}, {'i','f','l','v'}};
		String []words = {"oath","pea","eat","rain"};
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