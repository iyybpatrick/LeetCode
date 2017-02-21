import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int []result=new int[2];
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(target-numbers[i])){
				result[0]=map.get(target-numbers[i]);
				result[1]=i;
				return result;
			}//if
			map.put(numbers[i],i);
		}//for
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum A=new TwoSum();
		int [] result=new int[2];
		int [] num=new int[]{2,7,11,15};
		result=A.twoSum(num, 9);
		for(int i=0;i<2;i++)
			System.out.print(result[i]+"  ");
		
	}

}
