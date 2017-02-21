import java.util.*;
public class _49GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return new LinkedList<List<String>>();
        
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++){
        	char[] temp=strs[i].toCharArray();
        	Arrays.sort(temp);
        	String sorted=String.valueOf(temp);
        	if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<String>());
        	map.get(sorted).add(strs[i]);
        }//for
        return new LinkedList<List<String>>(map.values());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_49GroupAnagrams A=new _49GroupAnagrams();
		String[] str1={};
		String[] strs={"pen","ned","end","aaa","pne"};
		List<List<String>> result=A.groupAnagrams(strs);
		System.out.println(result);
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