import java.util.*;
public class _451SortCharactersByFrequency {

	public String frequencySort(String s) {
        if (s == null) return null;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (char c : s.toCharArray()){
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	maxCount = Math.max(maxCount, map.get(c));
        }
        List<Character> []charBucket =CalBucket(map, maxCount); 
        return BuildString(charBucket);
    }
	private String BuildString(List<Character>[] charBucket) {
		// TODO Auto-generated method stub
		StringBuilder finalStr = new StringBuilder();
		for (int i = charBucket.length - 1; i >= 0; i--){
			if (charBucket[i] != null){
				for (char c : charBucket[i]){
					finalStr.append(c);
				}//for
			}
		}//for i
		return finalStr.toString();
	}
	private List<Character>[] CalBucket(Map<Character, Integer> map, int maxCount) {
		// TODO Auto-generated method stub
		List<Character> []charBucket = new ArrayList[maxCount + 1];
		for (char c : map.keySet()){
			int val = map.get(c);
			if (charBucket[val] == null){
				charBucket[val] = new ArrayList<>();
			}
			for (int i = 0; i < val; i++){
				charBucket[val].add(c);
			}
		}
		return charBucket;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_451SortCharactersByFrequency A =new _451SortCharactersByFrequency();
		String s = "treeaabcddd";
		System.out.println(A.frequencySort(s));
	}

}

//question:
	//Given a string, sort it in decreasing order based on the frequency of characters.
	//
	//Example 1:
	//
	//Input:
	//"tree"
	//
	//Output:
	//"eert"
	//
	//Explanation:
	//'e' appears twice while 'r' and 't' both appear once.
	//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
	//Example 2:
	//
	//Input:
	//"cccaaa"
	//
	//Output:
	//"cccaaa"
	//
	//Explanation:
	//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
	//Note that "cacaca" is incorrect, as the same characters must be together.
	//Example 3:
	//
	//Input:
	//"Aabb"
	//
	//Output:
	//"bbAa"
	//
	//Explanation:
	//"bbaA" is also a valid answer, but "Aabb" is incorrect.
	//Note that 'A' and 'a' are treated as two different characters.