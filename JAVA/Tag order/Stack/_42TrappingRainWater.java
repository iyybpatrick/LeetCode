import java.util.*;
public class _42TrappingRainWater {

	public int trap(int[] height) {
		if (height == null || height.length ==0) return 0;
		int index = 0;
		int curMax = 0;
		int allMax = 0;
		Stack<Integer> stack = new Stack<>();
		while (index < height.length){
			if (stack.isEmpty() || height[stack.peek()] >= height[index]){
				stack.push(index++);
			}else{
				int pre = stack.pop();
				curMax = stack.isEmpty() ? 
						0 : (index - stack.peek() - 1) * (Math.min(height[index], height[stack.peek()]) - height[pre]);
				allMax +=curMax;
			}
		}//while
		return allMax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_42TrappingRainWater A =new _42TrappingRainWater();
		int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(A.trap(height));
	}

}

//question:
	//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	//
	//For example, 
	//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
