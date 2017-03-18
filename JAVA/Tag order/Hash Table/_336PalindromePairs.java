import java.util.*;
public class _336PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
        	map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++){
        	for (int j = 0; j <= words[i].length(); j++){
        		String first = words[i].substring(0, j);
        		String second = words[i].substring(j);
        		if (isPalindrome(first)){
        			String sec_rev = new StringBuilder(second).reverse().toString();
        			if (map.containsKey(sec_rev) && map.get(sec_rev) != i){
        				List<Integer> temp = new ArrayList<>();
        				temp.add(map.get(sec_rev));
        				temp.add(i);
        				res.add(temp);
        			}
        		}//if
        		
        		if (isPalindrome(second)){
        			String fir_rev = new StringBuilder(first).reverse().toString();
        			if (map.containsKey(fir_rev) && map.get(fir_rev) != i && second.length() != 0){
        				List<Integer> temp = new ArrayList<>();
        				temp.add(i);
        				temp.add(map.get(fir_rev));
        				res.add(temp);
        			}
        		}//if
        	}//for j
        }//for i
        return res;
    }
	
	private boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = str.length() - 1;
		while (start < end){
			if (str.charAt(start++) != str.charAt(end--)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []words = {"lls", "sssll"};
		_336PalindromePairs  A= new _336PalindromePairs ();
		List<List<Integer>> res = A.palindromePairs(words);
		System.out.println(res);
		
	}

}

//question:
	//Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
	//
	//Example 1:
	//Given words = ["bat", "tab", "cat"]
	//Return [[0, 1], [1, 0]]
	//The palindromes are ["battab", "tabbat"]
	//Example 2:
	//Given words = ["abcd", "dcba", "lls", "s", "sssll"]
	//Return [[0, 1], [1, 0], [3, 2], [2, 4]]
	//The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
