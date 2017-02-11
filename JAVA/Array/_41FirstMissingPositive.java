
public class _41FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        if(len<=0)
        	return 1;
        int i=0;
        while(i<len){
        	if(nums[i]!=(i+1)&&nums[i]>=1&&nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
        		int temp=nums[nums[i]-1];
        		nums[nums[i]-1]=nums[i];
        		nums[i]=temp;
        	}//if
        	else i++;
        }//while
        
        for(i=0;i<len;i++){
			if(nums[i]!=i+1)
				return (i+1);
		}//for
        return len+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_41FirstMissingPositive A=new _41FirstMissingPositive();
		int []a={1,-1,4,6,3,7};
		int find=A.firstMissingPositive(a);
		System.out.println(find);
	}

}

//question:
		//
		//Given an unsorted integer array, find the first missing positive integer.
		//
		//For example,
		//Given [1,2,0] return 3,
		//and [3,4,-1,1] return 2.
		//
		//Your algorithm should run in O(n) time and uses constant space.