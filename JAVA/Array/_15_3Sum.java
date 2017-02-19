import java.lang.reflect.Array;
import java.util.*;
public class _15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		
        List<List<Integer>> result=new ArrayList<>();
        int len=nums.length;
        if(len<=2)
        	return result;
        Arrays.sort(nums);
        int i,j,k;
        for(i=0;i<len-2;i++){
        	if(i!=0&&nums[i]==nums[i-1])
        		continue;
        	int remain=-nums[i];
        	j=i+1;
        	k=len-1;
        	while(j<k){
        		if(nums[j]+nums[k]==remain){
        			result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        			while(j<k&&nums[++j]==nums[j-1]) ;   //skip same result
        			while(j<k&&nums[--k]==nums[k+1]) ; 
        		}//if
        		else if(nums[j]+nums[k]<remain){
        			while(j<k&&nums[++j]==nums[j-1]) ;   //skip same result
        		}//if
        		else{
        			while(j<k&&nums[--k]==nums[k+1]) ; 
        		}//if
        	}//for
        }//for  
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_15_3Sum A=new _15_3Sum();
		List<List<Integer>> result=new ArrayList<>();
		int []a={-1,0,1,2,-1,2,1,1,-1,-4};
		result=A.threeSum(a);
		System.out.println(result);
		int []b={1,2,3,4,5};
		int m=0;
		while(b[++m]<3){
			System.out.println(b[m]+" "+m);
		}
		
	}

}
