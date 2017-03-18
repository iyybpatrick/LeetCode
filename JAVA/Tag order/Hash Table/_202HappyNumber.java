import java.util.*;
public class _202HappyNumber {

	public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int SquareSum = 0;
    	int cur = 0;
        while (inLoop.add(n)){
        	SquareSum = 0;
        	while (n != 0){
        		cur = n % 10;
        		SquareSum += cur * cur;
        		n /=10;
        	}
        	if (SquareSum == 1) {
        		return true;
        	}else{
        		n = SquareSum;
        	}
        }//while
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_202HappyNumber A =new _202HappyNumber();
		System.out.println(A.isHappy(19));
		
	}

}

//question:
	//Write an algorithm to determine if a number is "happy".
	//
	//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	//
	//Example: 19 is a happy number
	//
	//12 + 92 = 82
	//82 + 22 = 68
	//62 + 82 = 100
	//12 + 02 + 02 = 1