
public class _58LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if(s==null) return 0;
        int count=0;
        for (int i=s.length()-1;i>=0;i--){
        	while(i>=0 && s.charAt(i)==' ') i--;
        	count=0;
        	while(i>=0 && s.charAt(i)!=' '){
        		i--; 	
        		count++;
        	}//while
        	if(count!=0) break;
        }//for
        return count;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1="  ";
		String test=" 1_ s~!  t his is a te st  asc ";
		_58LengthOfLastWord A=new _58LengthOfLastWord();
		System.out.println(A.lengthOfLastWord(test));
	}

}

//while(i<s.length() && s.charAt(i)==' ') i++;
//
//if (i< s.length()) {
//	count=0;
//while(i< s.length() && s.charAt(i)!=' ') {
//	i++; count++;
//	}//while
//}//if

//question:
	//Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
	//return the length of last word in the string.
	//
	//If the last word does not exist, return 0.
	//
	//Note: A word is defined as a character sequence consists of non-space characters only.
	//
	//For example, 
	//Given s = "Hello World",
	//return 5.