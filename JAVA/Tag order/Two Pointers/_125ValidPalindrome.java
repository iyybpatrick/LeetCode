
public class _125ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int start = 0; 
		int end = s.length() -1;
		while (start < end){
			while(start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
			while(start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
			if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
				start++;
				end--;
			}else{
				return false;
			}//else
		}//while
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_125ValidPalindrome  A =new _125ValidPalindrome ();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(A.isPalindrome(s));
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