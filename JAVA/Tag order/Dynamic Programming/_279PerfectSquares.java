
public class _279PerfectSquares {

	public int numSquares(int n) {
	        if (n <= 0) return 0;
	        int []count = new int[n + 1];
	        count[0] = 0;
	        for (int i = 2 ; i <= n; i++){
	        	count[i] = Integer.MAX_VALUE;
	        }
	        for (int i = 1; i * i <= n; i++){
	        	count[i * i] = 1;
	        }
	        for (int i = 1; i <= n; i++){
	        	for (int j = 1; j < i; j++){
	        		if (count[j] + count[i - j] < count[i]){
	        			count[i] = count[j] + count[i - j];
	        		}
	        	}//for
	        	
	        }//for
	        return count[n];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_279PerfectSquares A =new _279PerfectSquares();
		System.out.println(A.numSquares(13));
	}

}

//question:
	//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	//
	//For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
