import java.util.*;
public class _84LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++){
        	int cur =  i == heights.length ? -1 : heights[i];
        	while (!stack.isEmpty() && heights[stack.peek()] > cur){
        		int index = stack.pop();
        		int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        		int area = (width) * heights[index];
        		maxArea = Math.max(maxArea, area);
        	}
        	stack.push(i);
        }//for
        return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_84LargestRectangleInHistogram A =new _84LargestRectangleInHistogram();
		int []heights = {4,2,0,3,2,5};
		System.out.println(A.largestRectangleArea(heights));
	}

}

//question:
	//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
	//
	//
	//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	//
	//
	//The largest rectangle is shown in the shaded area, which has area = 10 unit.
	//
	//For example,
	//Given heights = [2,1,5,6,2,3],
	//return 10.