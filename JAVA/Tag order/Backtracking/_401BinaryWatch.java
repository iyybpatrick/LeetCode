import java.util.*;
public class _401BinaryWatch {

	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int []nums1 = {1,2,4,8};
        int []nums2 = {1,2,4,8,16,32};
       for (int i = 0; i <= num; i++){
    	   List<Integer> hours = calHour(nums1, i);
    	   List<Integer> minutes = calMinute(nums2, num - i);
    	   
    	   for (int hour : hours){
    		   if (hour >= 12) continue;
    		   for (int minute : minutes){
    			   if (minute >= 60) continue;
    			   res.add(hour +":" + (minute < 10 ? "0" + minute : minute));
    		   }//for minute
    	   }//for hour
       }//for num
       return res;
    }
	private List<Integer> calHour(int[] nums1, int count) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		calDigitHelper(nums1, count, res, 0, 0);
		return res;
	}
	private List<Integer> calMinute(int[] nums2, int count) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		calDigitHelper(nums2, count, res, 0, 0);
		return res;
	}
	private void calDigitHelper(int[] nums, int count, List<Integer> res, int start, int sum) {
		// TODO Auto-generated method stub
		if (count ==0){
			res.add(sum);
			return;
		}
		for (int i = start; i < nums.length; i++){
			calDigitHelper(nums, count - 1, res, i + 1, sum + nums[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_401BinaryWatch A =new _401BinaryWatch();
		List<String> res= A.readBinaryWatch(3);
		System.out.println(res);
	}

}

//question:
	//A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
	//
	//Each LED represents a zero or one, with the least significant bit on the right.
	//
	//
	//For example, the above binary watch reads "3:25".
	//
	//Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
	//
	//Example:
	//
	//Input: n = 1
	//Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
	//Note:
	//The order of output does not matter.
	//The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
	//The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
