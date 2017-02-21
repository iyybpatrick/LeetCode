import java.util.*;
public class _67AddBinary {
	public String addBinary(String a, String b) {
       int cur1=a.length()-1, cur2=b.length()-1;
       StringBuilder res=new StringBuilder();
       int value1,value2,carry=0;
       while(cur1>=0 || cur2>=0){ 
    	   int sum=carry;
    	   if(cur1>=0) sum+=a.charAt(cur1--)-'0';
    	   if(cur2>=0) sum+=b.charAt(cur2--)-'0';
    	   carry=sum/2;
    	   res.append(sum%2);
       }//while
       if(carry==1) res.append(1);
       return res.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="110";
		String b="11";
		_67AddBinary A=new _67AddBinary();
		System.out.println(A.addBinary(a, b));
	}

}

//question:
	//Given two binary strings, return their sum (also a binary string).
	//
	//For example,
	//a = "11"
	//b = "1"
	//Return "100".