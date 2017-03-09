
public class _69Sqrt_x {

	public int mySqrt(int x) {
        if (x <= 0 ) return 0;
        int start  =1;
        int end = x;
        while (true){
        	int mid = start + (end - start)/2;
        	if (x/mid < mid){
        		end = mid - 1;
        	}else{
        		if (x /(mid + 1) < mid + 1){
        			return mid;
        		}else{
        		start = mid +1;
        		}
        	}
        }//while
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_69Sqrt_x A = new _69Sqrt_x();
		System.out.println(A.mySqrt(24));
	}

}

//question:
	//Implement int sqrt(int x).
	//
	//Compute and return the square root of x.
