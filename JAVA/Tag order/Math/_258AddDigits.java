
public class _258AddDigits {

	public int addDigits(int num) {
       if (num < 10) return num;
       int count = 0;
       while (true){
    	   while (num !=0){
	    	   count += num % 10;
	    	   num /= 10;
    	   }
    	   if (count < 10){
    		   return count;
    	   }else{
    		   num = count;
    		   count = 0;
    	   }  
       }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_258AddDigits A =new _258AddDigits();
		System.out.println(A.addDigits(398));
	}

}

//question:
	//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	//
	//For example:
	//
	//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	//
	//Follow up:
	//Could you do it without any loop/recursion in O(1) runtime?