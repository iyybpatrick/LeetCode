import java.util.Arrays;

public class _163Sum_Closest {

	 public int threeSumClosest(int[] nums, int target) {
	        int len=nums.length;
	        if(len<=2)
	        	return -1;
	        Arrays.sort(nums);
	        int min_val=Integer.MAX_VALUE;
	        int i,j,k,dif,sum_final=Integer.MAX_VALUE;
	        for(i=0;i<len-2;i++){
	        	j=i+1;
	        	k=len-1;
	        	while(j<k){
	        	int sum=nums[i]+nums[j]+nums[k];
	        	dif=Math.abs(sum-target);
	        	if(dif==0){
	        		return sum;
	        	}//if
	        	else if(dif<min_val){
	        		min_val=dif;
	        		sum_final=sum;
	        	}//else
	        	if(sum<target){
	        		while(j<k&&nums[++j]==nums[j-1]);
	        	}//if
	        	else{
	        		while(j<k&&nums[--k]==nums[k+1]);
	        	}
	        }//while
	        }//for
	        return sum_final;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []a={-1,2,1,-4};
		//int []a={-1,-4,-3,-3,-3,-2,-2,1,2,-4};
		int []a={-1,-2,-3,1};
		_163Sum_Closest A=new _163Sum_Closest();
		int find=A.threeSumClosest(a, -5);
		System.out.println(find);
	}

}
