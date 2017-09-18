/**
 * Created by YuebinYang on 2017/9/8.
 */
import java.util.*;
public class _93RestoreIPAddresses {

    //public List<String> restoreIpAddresses(String s) {
    //    List<String> result = new ArrayList<>();
    //
    //    if (s == null || s.length() < 4) return result;
    //
    //    List<Integer> ips = new ArrayList<>();
    //    for (int i = 0; i < 3; i++) {
    //        int tempIp = Integer.parseInt(s.substring(0, i + 1));
    //        if (tempIp < powerOfTen(i)) break;
    //        if (tempIp >= 0 && tempIp <= 255) {
    //            ips.add(tempIp);
    //            DFS(s, result, ips, i + 1);
    //            ips.remove(ips.size() - 1);
    //        }
    //    }
    //    return result;
    //}
    //
    //private int powerOfTen(int index) {
    //    if (index == 0) return -1;
    //    int result = 1;
    //    for (int i = 0; i < index; i++) {
    //        result *= 10;
    //    }
    //    return result;
    //}
    //
    //public void DFS(String s, List<String> result, List<Integer> ips, int startIdx) {
    //    if (startIdx == s.length()) {
    //        if (ips.size() == 4) {
    //            StringBuilder temp = new StringBuilder();
    //            for (int i = 0; i < 3; i++) {
    //                temp.append(""+ ips.get(i) + ".");
    //            }
    //            temp.append(""+ ips.get(3));
    //            result.add(temp.toString());
    //        }
    //        return;
    //    }
    //
    //    for (int i = startIdx; (i < startIdx + 3) && (i < s.length()); i++) {
    //        int tempIp = Integer.parseInt(s.substring(startIdx, i + 1));
    //        if (tempIp < powerOfTen(i - startIdx)) break;
    //        if (tempIp >= 0 && tempIp <= 255) {
    //            ips.add(tempIp);
    //            DFS(s, result, ips, i + 1);
    //            ips.remove(ips.size() - 1);
    //        }
    //    }
    //    return;
    //}

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<Integer> tempIP = new LinkedList<>();
        DFSHelper(0, s, tempIP, res);
        return res;
    }
    private void DFSHelper(int startIdx, String s, List<Integer> tempIP, List res) {

        if (tempIP.size() == 4 && startIdx == s.length()) {
            //transform linkedlist to string
            StringBuilder sb = new StringBuilder();
            for (int i : tempIP) {
                sb.append(Integer.toString(i)).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb);
            return;
        }
        if (tempIP.size() >= 4) {
            return;
        }
        for (int i = startIdx; i < startIdx + 3 && i < s.length(); i++) {
            int partOfIP = Integer.parseInt(s.substring(startIdx, i + 1));
            if (partOfIP >= 0 && partOfIP <= 255) {
                tempIP.add(partOfIP);
                DFSHelper(i + 1, s, tempIP, res);
                tempIP.remove(tempIP.size() - 1);
            }
        }
    }


    public static void main(String[] args){
        _93RestoreIPAddresses A =new _93RestoreIPAddresses();
        String s = "010010";
        //String []spit = s.split("\\.");
        //for (int i = 0; i < spit.length; i++) {
        //    System.out.println(spit[i]);
        //}


        List<String> result = A.restoreIpAddresses(s);
        System.out.println(result);

        //String str = "小学,初中,高中,大专,本科,研究生,博士";
        //String[] buff = str.split(",");
        //for(int i=0;i<buff.length;i++){
        //    System.out.println(buff[i]);
        //}
        //s = s + 1;
        //List<String> result = A.restoreIpAddresses(s);
        //System.out.println(result);
    }

}
