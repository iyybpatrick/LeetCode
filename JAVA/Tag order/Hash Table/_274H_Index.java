
public class _274H_Index {

	public int hIndex(int[] citations) {
		if (citations == null) return 0;
		int len = citations.length;
		int []count = new int[len + 1];
		for (int author : citations){
			if (author >= len){
				count[len]++;
			}else{
				count[author]++;
			}
		}//for
		int cites = 0;
		for (int i = len; i >= 0; i--){
			cites += count[i];
			if (cites >= i){
				return i;
			}
		}//for
		return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
	//
	//According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
	//
	//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.