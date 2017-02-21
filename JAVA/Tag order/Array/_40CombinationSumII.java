import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40CombinationSumII {

	
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> path= new ArrayList<>();
        int len=candidates.length;
        	DFS1(candidates,target,0,result,new ArrayList<Integer>());
        return result;
    }
	
	private void DFS1(int[] candidates, int target,int index,List<List<Integer>> result,List<Integer>path){
		if(target==0){
			result.add(new ArrayList<Integer>(path));
			return;
		}//if
		for(int i=index;i<candidates.length&&candidates[i]<=target;i++){
			if(i!=index&&candidates[i]==candidates[i-1])
				continue;
			path.add(candidates[i]);
			DFS1(candidates,target-candidates[i],i+1,result,path);
			path.remove(path.size()-1);
			
			
		}//for
		
	}//DFS1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_40CombinationSumII A =new _40CombinationSumII ();
		int []a={10,1,2,7,6,1,5};
		List<List<Integer>>result=new ArrayList<>();
		result=A.combinationSum2(a, 8);
		System.out.println(result);
	}

}


// question:
		//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
		//
		//Each number in C may only be used once in the combination.
		//
		//Note:
		//All numbers (including target) will be positive integers.
		//The solution set must not contain duplicate combinations.
		//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
		//A solution set is: 
		//[
		//  [1, 7],
		//  [1, 2, 5],
		//  [2, 6],
		//  [1, 1, 6]
		//]