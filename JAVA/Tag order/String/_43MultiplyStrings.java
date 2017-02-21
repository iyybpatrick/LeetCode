import java.util.*;
public class _43MultiplyStrings {
	
	public String multiply(String num1, String num2) {
        //if(num1==null||num2==null) return "";
        int len1=num1.length(),len2=num2.length();
        int res[]=new int[len1+len2];
        int mul,po;
        for(int i=len1-1;i>=0;i--){
        	for(int j=len2-1;j>=0;j--){
        		mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        		po=i+j;
        		int sum=mul+res[po+1];
        		res[po]+=sum/10;
        		res[po+1]=sum%10;
        	}//for
        }//for
        StringBuilder str=new StringBuilder();
        for( int x:res){
        	if (!(x==0&&str.length()==0))str.append(x);
        }//for
        if (str.length()==0) {
        	str.append(0);
        }//if
        return str.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_43MultiplyStrings A=new _43MultiplyStrings();
		String num1="0",num2="0";
		String str=A.multiply(num1, num2);
		System.out.print(str);
	}

}

//question:
	//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
	//
	//Note:
	//
	//The length of both num1 and num2 is < 110.
	//Both num1 and num2 contains only digits 0-9.
	//Both num1 and num2 does not contain any leading zero.
	//You must not use any built-in BigInteger library or convert the inputs to integer directly.