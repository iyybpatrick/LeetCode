
public class _14LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String first=strs[0];
        int cur=1;
        while(cur<strs.length){
        	while(strs[cur].indexOf(first)!=0){
        		first=first.substring(0, first.length()-1);
        	}//while
        	cur++;
        }//while
        return first;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []a={"thaa is a good day","this yes a good day","this day","this good"};
		_14LongestCommonPrefix A=new _14LongestCommonPrefix();
		System.out.println(A.longestCommonPrefix(a));
		
//		String a1="this is a good day";
//		String a2="this yes a good day";
//		String a3="this day";
		
	}

}
////question:
//Write a function to find the longest common prefix string amongst an array of strings.