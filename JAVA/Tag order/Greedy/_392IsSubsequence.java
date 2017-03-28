/**
 * Created by YuebinYang on 2017/3/27.
 */
public class _392IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0 ) return false;

        int idx_s = 0;
        int idx_t = 0;
        while (idx_s != s.length() && idx_t != t.length()){
            if (s.charAt(idx_s) == t.charAt(idx_t)){
                idx_s ++;
            }
                idx_t ++;
        }//while

        if (idx_s == s.length()) return true;
        return false;
        
    }
    
    public static void main(String[] args){

    }
}


//question;
//Given a string s and a string t, check if s is subsequence of t.
//
//        You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
//
//        A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
//
//        Example 1:
//        s = "abc", t = "ahbgdc"
//
//        Return true.
//
//        Example 2:
//        s = "axc", t = "ahbgdc"
//
//        Return false.
//
//        Follow up:
//        If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?