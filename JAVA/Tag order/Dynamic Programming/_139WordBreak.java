import java.util.*;
public class _139WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean []canSplit = new boolean [s.length() + 1];
        canSplit[0] = true;
        int wordMax = Findmax(wordDict);
        for (int i = 1; i <= s.length(); i++){
        	canSplit[i] = false;
        	for (int j = 1; j <= i && j <= wordMax; j++){
        		if (canSplit[i - j] == false) continue;
        		
        		String substring = s.substring(i - j, i);
        		//System.out.println(substring);
        		if (wordDict.contains(substring)){
        			canSplit[i] =true;
        			break;
        		}
        	}//for
        }//for
        return canSplit[s.length()];
    }
	private int Findmax(List<String> wordDict) {
		// TODO Auto-generated method stub
		int max = 0;
		for (String word : wordDict){
			max = max > word.length() ? max : word.length();
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_139WordBreak  A =new _139WordBreak ();
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		String s1 = "leet";
		String s2 = "code";
		wordDict.add(s1);
		wordDict.add(s2);
		System.out.println(A.wordBreak(s, wordDict));
	}

}

//question:
	//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
	//
	//For example, given
	//s = "leetcode",
	//dict = ["leet", "code"].
	//
	//Return true because "leetcode" can be segmented as "leet code".