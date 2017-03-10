
public class _268MissingNumber {
	
	public int missingNumber(int[] nums) {
        if (nums == null) return 0;
        int i = 0;
        while (i < nums.length){
        	if (nums[i] >= 0 && nums[i] <=nums.length -1 && nums[i] != i && nums[nums[i]] != nums[i]){
        		int temp = nums[i];
        		nums[i] = nums[temp];
        		nums[temp] = temp;
        	}else{
        		i++;
        	}
        }
        for ( i = 0; i < nums.length; i++){
        	if (nums[i] != i){
        		return i;
        	}
        }
        return nums.length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_268MissingNumber  A = new _268MissingNumber ();
		int [] nums = {0,1,2,4,5,3,6};
		System.out.println(A.missingNumber(nums));
	}

}

//question:
//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//For example,
//Given nums = [0, 1, 3] return 2.
//
//Note:
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?