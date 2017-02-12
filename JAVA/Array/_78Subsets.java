import java.util.*;
public class _78Subsets {

	private void DFS(List<List<Integer>> result,int[] nums,List<Integer> path,int start,int number){
		if(number==0){
			result.add(new ArrayList<>(path));
			return;
		}//if
		for(int i=start;i<nums.length;i++){
			if(i!=start&&nums[i]==nums[i-1])
					continue;
			path.add(nums[i]);
			DFS(result,nums,path,i+1,number-1);
			path.remove(path.size()-1);
		}//for
		
	}//DFS
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        result.add(path);
        if(nums.length==0)
        	return result;
        
        for(int number=1;number<=nums.length;number++){
	        		DFS(result,nums,path,0,number);
        }//for
        return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_78Subsets A=new _78Subsets();
		int []a={1};
		List<List<Integer>> result=A.subsets(a);
		System.out.println(result);
	}

}

//question:

	//Given a set of distinct integers, nums, return all possible subsets.
	//
	//Note: The solution set must not contain duplicate subsets.
	//
	//For example,
	//If nums = [1,2,3], a solution is:
	//
	//[
	//  [3],
	//  [1],
	//  [2],
	//  [1,2,3],
	//  [1,3],
	//  [2,3],
	//  [1,2],
	//  []
	//]