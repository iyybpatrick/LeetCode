
public class _28ImplementstrStr {

	public int strStr(String haystack, String needle) {
        if (haystack == null ) return -1;
        int len_ndl = needle.length();
        int len_hay = haystack.length();
        for (int i = 0; i <= len_hay - len_ndl; i++){
        	int start_hay = i;
        	int start_ndl = 0;
        	while (start_ndl < len_ndl && haystack.charAt(start_hay) == needle.charAt(start_ndl)){
        		start_hay ++;
        		start_ndl ++;
        	}
        	if (start_ndl == len_ndl){
        		return i;
        	}
        }//for
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "this";
		String needle = "t";
		_28ImplementstrStr A =new _28ImplementstrStr();
		System.out.println(A.strStr(haystack, needle));
	}

}

//question:
	//Implement strStr().
	//
	//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
