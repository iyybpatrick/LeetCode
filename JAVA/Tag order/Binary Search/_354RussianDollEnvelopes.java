import java.util.Arrays;
import java.util.Comparator;

public class _354RussianDollEnvelopes {

	public int maxEnvelopes(int[][] envelopes) {
         if (		envelopes == null 
        		 || envelopes.length == 0 
        		 || envelopes[0] == null 
        		 || envelopes[0].length != 2){
        	 return 0;
         }//if
         
         Arrays.sort(envelopes, new Comparator<int []>(){
        	 public int compare (int array1[], int array2[]){
        		 if (array1[0] == array2[0]){
        			 return array1[1] - array2[1];
        		 }else{
        			 return array1[0] - array2[0];
        		 }
        	 }
         });
         int len= envelopes.length;
         int []dp =new int[len];
         int max_size = 0;
         for (int i=0; i<len; i++){
        	 dp[i]=1;
        	 for (int j=0; j<i; j++){
        		 if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
        			 dp[i] = Math.max(dp[i], dp[j] +1);
        		 }
        	 }//for
        	 max_size = Math.max(max_size, dp[i]);
         }//for
			return max_size;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_354RussianDollEnvelopes A=new _354RussianDollEnvelopes();
		int envelopes [][]= {{4,5},{4,6},{6,7},{2,3},{1,1}};
		System.out.print(A.maxEnvelopes(envelopes));
	}

}

//question:
	//You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
	//
	//What is the maximum number of envelopes can you Russian doll? (put one inside other)
	//
	//Example:
	//Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
	//
	//Subscribe to see which companies asked this question.