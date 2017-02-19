import java.util.*;
public class _8StringToInteger_atoi {

	public int myAtoi(String str) {
		
		//  null string or start with non-numeric character
        if (str.length()==0)
        	return 0;
        int index=0, sign=1, total=0, digit=0;
      
        //  remove all zeros at front
        while(index<str.length()&&(str.charAt(index)=='0'||str.charAt(index)==' ')){
        	index++;
        }
        //  get sign 
        if (index<str.length()&&(str.charAt(index)=='+'||str.charAt(index)=='-')){
        	sign= (str.charAt(index)=='+'? 1:-1);
        	index++;
        }//if
       
        while (index<str.length()){
        	digit=str.charAt(index++)-'0';
        	if (digit>9||digit<0) {
        		break;
        	}//if
        	if ((total>Integer.MAX_VALUE/10) || (total==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10)){
        		
        		return (sign== 1 ? Integer.MAX_VALUE :Integer.MIN_VALUE);
        	}//if
        	total=total*10+digit;
        	
        }//while
        
        return total*sign;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_8StringToInteger_atoi A=new _8StringToInteger_atoi();
		String test="2147483648";
		System.out.print(A.myAtoi(test));
	}

}

//question:
	//Implement atoi to convert a string to an integer.
	//
	//Hint: Carefully consider all possible input cases. 
	//If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	//
	//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
	//You are responsible to gather all the input requirements up front.
	//
	//Update (2015-02-10):
	//The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, 
	//please click the reload button  to reset your code definition.