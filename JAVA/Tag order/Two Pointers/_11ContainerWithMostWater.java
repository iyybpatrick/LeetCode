
public class _11ContainerWithMostWater {

	public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (lo < hi){
        	int minHeight = Math.min(height[lo], height[hi]);
        	int Hlo = height[lo];
        	int Hhi = height[hi];
        	max = Math.max(max, (hi - lo) * minHeight);
        	if (height[lo] <= height[hi]){
        		while (lo < hi && height[lo] <= Hlo) ++lo;	
        	}else{
        		while (lo < hi && height[hi] <= Hhi) --hi;
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_11ContainerWithMostWater A =new _11ContainerWithMostWater();
		int []height = {2,5,7,8};
		System.out.println(A.maxArea(height));
	}

}

//question:
	//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
	//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
	//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	//
	//Note: You may not slant the container and n is at least 2.

