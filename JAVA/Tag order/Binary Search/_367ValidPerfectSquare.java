
public class _367ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long low = 1;
        long high = num;
         while (low <= high){
        	 
        	 long mid = low + (high-low)/2;
        	 long multi = mid * mid;
        	 if (multi == num){
        		 return true;
        	 }
        	 if (multi < num){
        		 low = mid + 1;
        	 }else{
        		 high = mid - 1;
        	 }
         }//while
         return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_367ValidPerfectSquare A= new _367ValidPerfectSquare();
		System.out.print(A.isPerfectSquare(9987));
	}

}

//question:
	//Given a positive integer num, write a function which returns True if num is a perfect square else False.
	//
	//Note: Do not use any built-in library function such as sqrt.
	//
	//Example 1:
	//
	//Input: 16
	//Returns: True
	//Example 2:
	//
	//Input: 14
	//Returns: False