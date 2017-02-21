
public class _28ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if(haystack==null||needle==null) return -1;
		int len_ori=haystack.length();
		int len_sub=needle.length();
		int index;
		if(len_ori<len_sub) return -1;
		else if(len_sub==0) return 0;
		// times for searching
		for(int i=0;i <len_ori-len_sub+1 ;i++){
				index=0;
			for(int j=i;j<len_ori;j++){
				if (haystack.charAt(j)!=needle.charAt(index)){
					break;
				}//if
				index++;
				if(index==len_sub) {
					return i;
				}//if
			}//for
		}//for
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_28ImplementstrStr A=new _28ImplementstrStr();
		String string=null;
		String sub="1";
		System.out.println(A.strStr(string, sub));
	}

}

//question：
	//Implement strStr().
	//
	//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	//
