import java.util.*;
public class _91DecodeWays {
	
	public int numDecodings(String s) {
        if (s==null || s.length()==0) {
        	return 0;
        }
        int len=s.length();
        int []n=new int [len+1];
        n[len]=1;
        n[len-1]= s.charAt(len-1) != '0' ? 1:0;
        for(int i=len-2;i>=0;i--){
        	if(s.charAt(i)=='0') continue;
        	n[i]= Integer.parseInt(s.substring(i, i+2)) < 26 ? n[i+1]+n[i+2] :n[i+1];
        }//for
        return n[0];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="122121";
		_91DecodeWays A=new _91DecodeWays();
		System.out.println(A.numDecodings(s));
	}

}

//question:
	//A message containing letters from A-Z is being encoded to numbers using the following mapping:
	//
	//'A' -> 1
	//'B' -> 2
	//...
	//'Z' -> 26
	//Given an encoded message containing digits, determine the total number of ways to decode it.
	//
	//For example,
	//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	//
	//The number of ways decoding "12" is 2.