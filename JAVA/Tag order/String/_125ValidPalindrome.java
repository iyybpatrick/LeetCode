
public class _125ValidPalindrome {

	public boolean isPalindrome(String s) {
        if(s==null) return false;
        int len=s.length();
        int start=0,end=len-1;
        while(start<=end){
        	while(start<=end && !Character.isLetterOrDigit(s.charAt(start))){
        		start++;
        	}
        	while(start<=end && !Character.isLetterOrDigit(s.charAt(end))){
        		end--;
        	}
        	if (start<=end && !(Character.toLowerCase(s.charAt(start))==Character.toLowerCase(s.charAt(end)))){
        		return false;
        	}
        	start++;
        	end--;
        }//while
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_125ValidPalindrome A=new _125ValidPalindrome();
		String test1=" ";
		String test="A man, a plan, a canal: Panama";
		System.out.println(A.isPalindrome(test1));
	}

}

//question:
	//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	//
	//For example,
	//"A man, a plan, a canal: Panama" is a palindrome.
	//"race a car" is not a palindrome.
	//
	//Note:
	//Have you consider that the string might be empty? This is a good question to ask during an interview.
	//
	//For the purpose of this problem, we define empty string as valid palindrome.