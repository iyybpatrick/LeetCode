/**
 * Created by YuebinYang on 9/27/17.
 */
import java.util.*;
public class _17RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;

    }
    public static void main(String[] args){

        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("I", 1);
        numberMap.put("II", 2);
        numberMap.put("III", 3);
        numberMap.put("IV", 4);
        numberMap.put("V", 5);
        numberMap.put("VI", 6);
        numberMap.put("VII", 7);
        numberMap.put("VIII", 8);
        numberMap.put("IX", 9);
        numberMap.put("X", 10);
        numberMap.put("XX", 20);
        numberMap.put("XXX", 30);
        numberMap.put("XL", 40);
        numberMap.put("L", 50);
        
        String[] strs = new String[2];
        strs[0] = "Louis IX";
        //strs[1] = "Louis IXLVII";
        strs[1] = "Louis VIII";
        //strs[3] = "Philippe II";
        //Louis IX
        //Louis VIII
        Arrays.sort(strs, new Comparator<String>() {
            @Override

            public int compare(String o1, String o2) {
                String[] tuple1 = o1.split(" ");
                String[] tuple2 = o2.split( " ");
                if (!tuple1[0].equals(tuple2[0])) {
                    return tuple1[0].compareTo(tuple2[0]);
                }
                return converToInt(tuple2[1]) - converToInt(tuple1[1]);
            }

            private int converToInt(String s) {
                int number = 0;
                int idx = 0;
                while (idx < s.length()) {
                    System.out.println("idx:" + idx);
                    System.out.println("Slength :" + s.length());
                    if ((idx + 4) <= s.length()) {

                        if (numberMap.containsKey(s.substring(idx, idx + 4))) {
                            System.out.print(" 4:" + s.substring(idx, idx + 4) +" ");
                            number += numberMap.get(s.substring(idx, idx + 4));
                            idx += 4;
                            continue;
                        }
                    }
                    if ((idx + 3) <= s.length()) {
                        if (numberMap.containsKey(s.substring(idx, idx + 3))) {
                            System.out.print(" 3:" + s.substring(idx, idx + 3) +" ");
                            number += numberMap.get(s.substring(idx, idx + 3));
                            idx += 3;
                            continue;
                        }
                    }
                    if ((idx + 2) <= s.length()) {
                        if (numberMap.containsKey(s.substring(idx, idx + 2))) {
                            System.out.print(" 2:" + s.substring(idx, idx + 2) +" ");
                            number += numberMap.get(s.substring(idx, idx + 2));
                            idx += 2;
                            continue;
                        }
                    }
                    if (numberMap.containsKey(s.substring(idx, idx + 1))) {
                        System.out.print(" 1:" + s.substring(idx, idx + 1) +" ");
                        number += numberMap.get(s.substring(idx, idx + 1));
                        idx += 1;
                        continue;
                    }
                }
                System.out.println(s + " " + number);
                return number;
            }
        });

        for (int i =0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
