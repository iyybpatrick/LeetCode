import java.util.*;
public class _140WordBreakII {
	
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
  
        boolean [][]isWord = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
        	for (int j = i; j < s.length(); j ++){
        		String word = s.substring(i, j + 1);
        		isWord[i][j] = wordDict.contains(word);
        	}//for
        }//for
        boolean []possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length(); i >=0; i--){
        	for (int j = i; j < s.length(); j++){
        		if (isWord[i][j] && possible[j + 1]){
        			possible[i] =true;
        			break;
        		}//if
        	}//for
        }//for
        List<Integer> path = new LinkedList<>();
        search (0, s, path, isWord, possible, res);
        return res;
        
        
    }
	private void search(int index, String s, List<Integer> path, boolean[][] isWord, boolean[] possible, List<String> res) {
		// TODO Auto-generated method stub
		if (!possible[index]) return; 
		
		if (index == s.length()){
			StringBuilder temp = new StringBuilder();
			int lastIdx = 0;
			for (int i = 0; i < path.size(); i++){
				temp.append(s.substring(lastIdx, path.get(i)));
				if (i != path.size() -1)
					temp.append(" ");
				lastIdx = path.get(i);
			}//for
			res.add(temp.toString());
		}
		
		for (int i = index; i < s.length(); i++){
			if (!isWord[index][i])
				continue;
			path.add(i + 1);
			search (i + 1, s, path, isWord, possible,res);
			path.remove(path.size() - 1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_140WordBreakII A =new _140WordBreakII();
		String s= "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("dog");
		wordDict.add("sand");
		List<String> res = A.wordBreak(s, wordDict);
		System.out.println(res);
	}

}

//question:
	//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
	//
	//Return all such possible sentences.
	//
	//For example, given
	//s = "catsanddog",
	//dict = ["cat", "cats", "and", "sand", "dog"].
	//
	//A solution is ["cats and dog", "cat sand dog"].
	//
	//UPDATE (2017/1/4):
	//The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

