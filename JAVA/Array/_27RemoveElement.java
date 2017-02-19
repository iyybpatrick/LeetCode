
public class _27RemoveElement {

	 public int removeElement(int[] nums, int val) {
	        int len=nums.length;
	        int k=0;
	        for(int i=0;i<len;i++){
	        	if(nums[i]!=val){
	        		nums[k++]=nums[i];
	        	}//if
	        }//for
	        return k;	 
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={3,4,5,2,1,6,2,2,1,1};
		_27RemoveElement A=new _27RemoveElement();
		int length=A.removeElement(a, 2);
		System.out.println(length);
		for(int i=0;i<length;i++){
			System.out.print(a[i]+" ");
		}//for
	}

}


//  question:
		//Given an array and a value, remove all instances of that value in place and return the new length.
		//
		//Do not allocate extra space for another array, you must do this in place with constant memory.
		//
		//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
		//
		//Example:
		//Given input array nums = [3,2,2,3], val = 3
		//
		//Your function should return length = 2, with the first two elements of nums being 2.