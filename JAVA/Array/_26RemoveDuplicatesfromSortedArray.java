
public class _26RemoveDuplicatesfromSortedArray {
	
	public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len<=1)
        	return len;
        int k=1;
        for(int i=1;i<len;i++){
        	if(nums[i]!=nums[k-1]){
        		nums[k++]=nums[i];
        	}//if
        }//for
        return k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_26RemoveDuplicatesfromSortedArray A=new _26RemoveDuplicatesfromSortedArray();
		int []a={1,1,1,2,2,2,3,3,4,5,5,6,6,6};
		int []a1={1};
		int lenth=A.removeDuplicates(a1);
		System.out.println(lenth);
		for(int i=0;i<lenth;i++)
			System.out.print(a[i]+" ");
	}

}


// question:
		//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
		//
		//Do not allocate extra space for another array, you must do this in place with constant memory.
		//
		//For example,
		//Given input array nums = [1,1,2],
		//
		//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
