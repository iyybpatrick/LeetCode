import java.util.*;
public class _49GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
	
		if (strs == null) return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs){
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String cur = String.valueOf(temp);
			if (!map.containsKey(cur)){
				map.put(cur, new ArrayList<String>());
			}
				map.get(cur).add(str);
		}//for
		return new LinkedList<List<String>>(map.values());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_49GroupAnagrams A =new _49GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res =A.groupAnagrams(strs);
		System.out.print(res);
	}

}

//question:
	//Given an array of strings, group anagrams together.
	//
	//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	//Return:
	//
	//[
	//  ["ate", "eat","tea"],
	//  ["nat","tan"],
	//  ["bat"]
	//]