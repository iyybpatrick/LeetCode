
public class _5LongestPalindromicSubstring {
	private int index_low,max_len;
	public String longestPalindrome(String s) {
        int len=s.length();
        if(len<=1) return s;
        for (int i=0;i<len-1;i++){
        	find_palindromic(s,i,i);   		 //odd palindrome
        	find_palindromic(s,i,i+1); 		 // even palindrome
        }//for
        //System.out.println(index_low+" "+max_len);
        return s.substring(index_low, index_low+max_len);
    }
	private void find_palindromic(String s,int low,int high){
		while(low>=0&&high<s.length()&&s.charAt(low)==s.charAt(high)){
			low--;
			high++;
		}//while
		if(max_len<(high-low-1)){
			index_low=low+1;
			max_len=high-low-1;
		}//if
		
	}//find_palidromic
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_5LongestPalindromicSubstring A=new _5LongestPalindromicSubstring();
		String test="babad";
		String test1="aba";
		System.out.println(A.longestPalindrome(test1));
	}

}

//question:
	//Given a string s, find the longest palindromic substring in s.
	//You may assume that the maximum length of s is 1000.
	//Example:
	//
	//Input: "babad"
	//
	//Output: "bab"
	//
	//Note: "aba" is also a valid answer.
	//Example:
	//
	//Input: "cbbd"
	//
	//Output: "bb"