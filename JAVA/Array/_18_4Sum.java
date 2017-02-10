import java.util.*;

public class _18_4Sum {

public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int len=nums.length;
		if(len<=3)
			return result;
		Arrays.sort(nums);
		int i,j,k,m;
		for(i=0;i<len-3;i++){
			if(i!=0&&nums[i]==nums[i-1]){
				continue;
			}//if
			
			for(j=i+1;j<len-2;j++){
				if(j!=i+1&&nums[j]==nums[j-1]){
					continue;
				}//if
				int remain=-nums[i]-nums[j]+target;
				k=j+1;
				m=len-1;
				while(k<m){
					if(nums[k]+nums[m]==remain){
						result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[m]));
						while(k<m&&nums[++k]==nums[k-1]);
						while(k<m&&nums[--m]==nums[m+1]);
					}//if
					else if(nums[k]+nums[m]<remain){
						while(k<m&&nums[++k]==nums[k-1]);
					}//if
					else{
						while(k<m&&nums[--m]==nums[m+1]);
					}
				}//while
			}//for
		}//for
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={-1,-4,-3,-3,-3,-2,-2,1,2,-4};
		int []a1={1,0,-1,0,-2,2};
		int []a2={1,-2,-5,-4,-3,3,3,5};
		int []a3={1,2,3};
		_18_4Sum A=new _18_4Sum();
		List<List<Integer>> result=A.fourSum(a1, 0);
		System.out.println(result);
	}//4sum
}


// question
//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note: The solution set must not contain duplicate quadruplets.
//
//For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]