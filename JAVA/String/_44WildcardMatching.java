import java.util.*;
public class _44WildcardMatching {
	
	public boolean isMatch(String s, String p) {
        if(s==null&&p==null) return false;
        int len1=s.length(), len2=p.length();
        int i=0,j=0;
        while(i!=len1&&j!=len2){
        	
        }//while
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int [5][5];
		a[4][4]=3;
		for(int i=0;i<5;i++){
			for (int j=0;j<5; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}//for
		
		for(int i=4;i>=0;i--){
			a[4][i]=2;
		}
	}

}

//question:
	//Implement wildcard pattern matching with support for '?' and '*'.
	//
	//'?' Matches any single character.
	//'*' Matches any sequence of characters (including the empty sequence).
	//
	//The matching should cover the entire input string (not partial).
	//
	//The function prototype should be:
	//bool isMatch(const char *s, const char *p)
	//
	//Some examples:
	//isMatch("aa","a") → false
	//isMatch("aa","aa") → true
	//isMatch("aaa","aa") → false
	//isMatch("aa", "*") → true
	//isMatch("aa", "a*") → true
	//isMatch("ab", "?*") → true
	//isMatch("aab", "c*a*b") → false