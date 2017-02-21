
public class _345ReverseVowelsOfAString {

	public String reverseVowels(String s) {
        if(s==null) return s;
        char[] word=s.toCharArray();
        int start=0, end=s.length()-1;
        
        while(start<end){
        	while(start<end && !(Character.toLowerCase(word[start])=='a' 
        						||Character.toLowerCase(word[start])=='e' 
        						||Character.toLowerCase(word[start])=='i' 
        						||Character.toLowerCase(word[start])=='o' 
        						||Character.toLowerCase(word[start])=='u')){
        		start++;
        	}//while
        	while(start<end && !(Character.toLowerCase(word[end])=='a' 
								||Character.toLowerCase(word[end])=='e' 
								||Character.toLowerCase(word[end])=='i' 
								||Character.toLowerCase(word[end])=='o' 
								||Character.toLowerCase(word[end])=='u')){
        		end--;
        	}//while
        	if(start<end){
        		char temp=word[start];
        		word[start++]=word[end];
        		word[end--]=temp;
        	}
        }//while
        return new String(word);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_345ReverseVowelsOfAString A=new _345ReverseVowelsOfAString();
		String test="helalelo";
		String test1=" acm e";
		System.out.println(A.reverseVowels(test1));
	}

}

//question:
	//Write a function that takes a string as input and reverse only the vowels of a string.
	//
	//Example 1:
	//Given s = "hello", return "holle".
	//
	//Example 2:
	//Given s = "leetcode", return "leotcede".
	//
	//Note:
	//The vowels does not include the letter "y".