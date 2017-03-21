import java.util.*;
public class _60PermutationSequence {
	
	public String getPermutation(int n, int k) {
        int []factorial = new int[n + 1];
        factorial[0] = 1;
        int sum = 1;
        for (int i = 1; i <= n; i++){
        	factorial[i] = i * factorial[i - 1];
        }
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
        	list.add(i);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n ; i++){
        	int index = k / factorial[n - i];
        	str.append(list.get(index));
        	list.remove(index);
        	k -= index * factorial[n - i];
        }//for
        return str.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_60PermutationSequence A =new _60PermutationSequence();
		String res = A.getPermutation(3, 6);
		System.out.println(res);
		
	}

}

//question:
	//The set [1,2,3,…,n] contains a total of n! unique permutations.
	//
	//By listing and labeling all of the permutations in order,
	//We get the following sequence (ie, for n = 3):
	//
	//"123"
	//"132"
	//"213"
	//"231"
	//"312"
	//"321"
	//Given n and k, return the kth permutation sequence.
	//
