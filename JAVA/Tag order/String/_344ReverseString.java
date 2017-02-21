
public class _344ReverseString {
    public String reverseString(String s) {
	        if(s==null||s.length()<=1) return s;
	        char[] word=s.toCharArray();
	        int start=0,end=s.length()-1;
	        
	        while (start < end){
	        	char temp=word[start];
	        	word[start++]=word[end];
	        	word[end--]=temp;
	        }//while
	        return new String(word);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_344ReverseString A=new _344ReverseString();
		String test="nihaoma";
		System.out.println(A.reverseString(test));
	}

}

//question:
	//Write a function that takes a string as input and returns the string reversed.
	//
	//Example:
	//Given s = "hello", return "olleh".