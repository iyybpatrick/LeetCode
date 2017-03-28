/**
 * Created by YuebinYang on 2017/3/27.
 */
import java.util.*;
public class _316RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> minLastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            minLastPos.put(s.charAt(i), i);
        }

        int start = 0;
        int end = findMinLast(minLastPos);
        StringBuilder str = new StringBuilder();
        int size = minLastPos.size();
        for (int i = 0; i < size; i++){
            char minChar = 'z' + 1;
            for (int j = start; j <= end; j++){
                char cur = s.charAt(j);
                if (minLastPos.containsKey(cur) && cur < minChar){
                    minChar = cur;
                    start = j + 1;
                }
            }// for j

            str.append(minChar);
            if (str.length() == size) break;

            minLastPos.remove(minChar);
            if (s.charAt(end) == minChar)
            end = findMinLast(minLastPos);
        }
        return str.toString();
    }

    private int findMinLast(Map<Character, Integer> map) {

        if (map == null || map.size() == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()){
            if (map.get(c) < min){
                min = map.get(c);
            }
        }
        return min;
    }

    public static void main(String[] args){
        _316RemoveDuplicateLetters A =new _316RemoveDuplicateLetters();
        String s = "abcdbcabc";
        System.out.println(A.removeDuplicateLetters(s));
    }
}

//question:
//
//        Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//        Example:
//        Given "bcabc"
//        Return "abc"
//
//        Given "cbacdcbc"
//        Return "acdb"
//
