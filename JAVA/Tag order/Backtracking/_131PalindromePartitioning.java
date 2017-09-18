/**
 * Created by YuebinYang on 9/18/17.
 */
import java.util.*;
public class _131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        List<String> path = new LinkedList<>();

        DFS(s, result, path, 0);
        return result;
    }

    public void DFS(String s, List<List<String>> result, List<String> path, int startIdx) {
        if (startIdx == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIdx + 1; i <= s.length(); i++) {
            String temp = s.substring(startIdx, i);
            if (validPartition(temp)) {
                path.add(temp);
                DFS(s, result, path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean validPartition(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
