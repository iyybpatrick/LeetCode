
public class _274H_Index {

	public int hIndex(int[] citations) {
        if (citations == null) return 0;
        int len = citations.length;
        int count[]= new int [len+1];
        
        //count the number of authors for each citation value.
        for (int author : citations){
        	if (author >= len){
        		count[len]++;
        	}else{
        		count[author]++;
        	}
        }//for
        int total=0;
        for (int i=len; i>=0; i--){
        	total += count[i];
        	if (total >=i){
        		return i;
        	}
        }//for
        return 0;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 _274H_Index  A= new  _274H_Index ();
		 int citations[]= {3,4,5,1,5};
		 System.out.println(A.hIndex(citations));
	}

}

//question:
	//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
	//
	//According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
	//
	//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
	//
	//Note: If there are several possible values for h, the maximum one is taken as the h-index.
	//
