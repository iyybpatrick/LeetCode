
public class _167TwoSumIIInputarrayIsSorted {

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null ) return new int[]{-1,-1};
		int start = 0;
		int end = numbers.length -1;
		while (start < end){
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				return new int[]{start +1, end + 1};
			}else if (sum > target) {
				end--;
			}else{
				start++;
			}
		}//while
		return new int[]{-1,-1};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_167TwoSumIIInputarrayIsSorted A =new _167TwoSumIIInputarrayIsSorted();
		int []numbers = {1,3,5,7,9,11,12};
		int []res = A.twoSum(numbers, 11);
		System.out.println(res[0] +" "+res[1]);
	}

}

//question:
	//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	//
	//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	//
	//You may assume that each input would have exactly one solution and you may not use the same element twice.
	//
	//Input: numbers={2, 7, 11, 15}, target=9
	//Output: index1=1, index2=2