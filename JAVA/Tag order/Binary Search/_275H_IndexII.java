
public class _275H_IndexII {

	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int end = len-1;
        int start = 0;
        int max = 0;
        while (start <= end ){
        	int mid = start + (end - start)/2;
        	if ((len-mid) >= citations[mid]){
        		 max = Math.max(max, citations[mid]);
        		 start = mid+1;
        	}else{
        		 max = Math.max(max, len-mid);
        		 end = mid-1;
        	}
        }//while
       return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_275H_IndexII A=new _275H_IndexII();
		int citations[]= {4,4,4,4,4,5,6,6,6,6,6};
		int citations1[]= {0,0,4,4};
		System.out.println(A.hIndex(citations1));
	}
}

//question:
//Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?