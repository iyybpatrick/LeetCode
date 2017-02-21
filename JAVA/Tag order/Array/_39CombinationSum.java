import java.util.*;
public class _39CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> path= new ArrayList<>();
        int len=candidates.length;
        	DFS(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }
	
	private void DFS(int[] candidates, int target,int index,List<List<Integer>> result,List<Integer>path){
		if(target==0){
			result.add(new ArrayList<Integer>(path));
			return;
		}//if
		for(int i=index;i<candidates.length;i++){
			if(candidates[i]>target){
				return;
			}//if
			path.add(candidates[i]);
			DFS(candidates,target-candidates[i],i,result,path);
			path.remove(path.size()-1);
		}//for
		
	}//DFS
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_39CombinationSum A =new _39CombinationSum ();
		int []a={3,4,7,1,6};
		List<List<Integer>>result=new ArrayList<>();
		result=A.combinationSum(a, 7);
		System.out.println(result);
	}

}




//question:

		//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
		//
		//The same repeated number may be chosen from C unlimited number of times.
		//
		//Note:
		//All numbers (including target) will be positive integers.
		//The solution set must not contain duplicate combinations.
		//For example, given candidate set [2, 3, 6, 7] and target 7, 
		//A solution set is: 
		//[
		//  [7],
		//  [2, 2, 3]
		//]