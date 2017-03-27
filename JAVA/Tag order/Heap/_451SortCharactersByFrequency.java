/**
 * Created by YuebinYang on 2017/3/27.
 */
import java.util.*;
public class _451SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c : map.keySet()){
            int frequency = map.get(c);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = s.length(); i >= 0; i--){
            if (bucket[i] != null){
                for (char c : bucket[i]){
                    for (int j = 0; j < i; j++)
                    str.append(c);
                }
            }
        }//for i

        return str.toString();
    }
    public static void main(String[] args){
        _451SortCharactersByFrequency A =new _451SortCharactersByFrequency();
        String s= "helloo";
        System.out.println(A.frequencySort(s));
    }
}


//question:
//Given a string, sort it in decreasing order based on the frequency of characters.
//
//        Example 1:
//
//        Input:
//        "tree"
//
//        Output:
//        "eert"
//
//        Explanation:
//        'e' appears twice while 'r' and 't' both appear once.
//        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//        Example 2:
//
//        Input:
//        "cccaaa"
//
//        Output:
//        "cccaaa"
//
//        Explanation:
//        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//        Note that "cacaca" is incorrect, as the same characters must be together.
//        Example 3:
//
//        Input:
//        "Aabb"
//
//        Output:
//        "bbAa"
//
//        Explanation:
//        "bbaA" is also a valid answer, but "Aabb" is incorrect.
//        Note that 'A' and 'a' are treated as two different characters.
