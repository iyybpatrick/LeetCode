
public class _231PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		if (n == 0) return false;
        while ( n != 1){
        	if (n % 2 != 0){
        		return false;
        	}
        	n /=2;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_231PowerOfTwo A =new _231PowerOfTwo();
		System.out.println(A.isPowerOfTwo(1));
	}

}

//question:
//Given an integer, write a function to determine if it is a power of two.