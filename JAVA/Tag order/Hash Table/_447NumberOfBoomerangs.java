import java.util.*;
public class _447NumberOfBoomerangs {
	
	public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++){
        	for (int j = 0; j < points.length; j++){
        		if (i == j) continue;
        		int dis = getDistance(points[i], points[j]);
        		map.put(dis, map.getOrDefault(dis, 0) + 1);
        	}
        	
        	for (int val : map.values()){
        		res += val * (val - 1);
        	}
        	map.clear();
        }//for
        return res;
    }
	
	private int getDistance(int[] pt1, int[] pt2) {
		// TODO Auto-generated method stub
		int x = pt1[0] - pt2[0];
		int y = pt1[1] - pt2[1];
		return x*x + y*y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]points = {{0,0},{1,0},{2,0}};
		_447NumberOfBoomerangs  A= new _447NumberOfBoomerangs ();
		System.out.println(A.numberOfBoomerangs(points));
	}

}

//question:
	//Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
	//
	//Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
	//
	//Example:
	//Input:
	//[[0,0],[1,0],[2,0]]
	//
	//Output:
	//2
	//
	//Explanation:
	//The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]