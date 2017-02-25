
public class _69Sqrtx {

	public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (true){
        	int mid = low + (high-low)/2;
        	if ( mid > x/mid){
        		high = mid-1;
        	}else {
        		if (mid+1 > x/(mid+1)){
        			return mid;
        		}
        		low=mid+1;
        	}
        }//while
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 _69Sqrtx A=new  _69Sqrtx();
		 System.out.print(A.mySqrt(3));
	}

}
//question:
	//Implement int sqrt(int x).
	//
	//Compute and return the square root of x.
