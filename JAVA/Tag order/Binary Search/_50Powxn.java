
public class _50Powxn {

	public double myPow(double x, int n) {
			if ( x == 0) return 0;
			if ( n == 0) return 1;
			if ( n < 0){
				x = 1/x;
				n = -n;
			}
			return n % 2 == 0 ? myPow(x*x, n/2) : x* myPow(x*x,n/2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_50Powxn A=new _50Powxn();
		double x=2.0;
		System.out.println(A.myPow(x, -9));
	}

}

//question:
	//Implement pow(x, n).