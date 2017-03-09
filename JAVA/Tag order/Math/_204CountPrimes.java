
public class _204CountPrimes {

	public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean []notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++){
        	if (notPrime[i] == false){
        		count++;
        		for (int j = 2; j * i < n; j++){
        			notPrime[j*i] = true;
        		}//for
        	}
        }//for
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] a= new boolean[3];
		_204CountPrimes A =new _204CountPrimes();
		System.out.println(A.countPrimes(10));
		
	}

}

//question:
	//Description:
	//
	//Count the number of prime numbers less than a non-negative number, n.