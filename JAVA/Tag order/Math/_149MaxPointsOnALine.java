import java.util.*;
public class _149MaxPointsOnALine {

	public static class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	 public int maxPoints(Point[] points) {
	        if (points == null || points.length == 0) return 0;
	        
	        Map <Integer,Map<Integer,Integer>> map = new HashMap<>();
	        int res = 0;
	        int overlap = 0;
        	int max = 0;
	        for (int i = 0; i < points.length; i++){
	        	map.clear();
	        	overlap = 0;
	        	max = 0;
	        	
	        	for (int j = i + 1; j < points.length; j++){
	        		int x = points[i].x - points[j].x;
	        		int y = points[i].y - points[j].y;
	        		if (x == 0 && y == 0){
	        			overlap++;
	        		}else{	
	        			int gcd = GetGCD(x, y);
		        		if (gcd != 0){
			        		x /=gcd;
			        		y /=gcd;
		        		}
		        		if (map.containsKey(x)){
			        		if (map.get(x).containsKey(y)){
			        			map.get(x).put(y, map.get(x).get(y) + 1);
			        		}else{
			        			map.get(x).put(y, 1);
			        		}//else
		        		}else{
		        			Map<Integer,Integer> m = new HashMap<>();
		        			m.put(y, 1);
		        			map.put(x, m);
		        		}
		        		max = Math.max(max, map.get(x).get(y));
	        		}//else
	        	}//for
	        	res = Math.max(res, max + overlap + 1);
	        }//for
	        return res;  
	    }
	private int GetGCD(int x, int y) {
		// TODO Auto-generated method stub
		if (y == 0) return x;
		return GetGCD(y, x % y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(2,3);
		Point p2 = new Point(4,6);
		Point p3 = new Point(12,18);
		Point p4 = new Point(2,6);
		Point p5 = new Point(3,5);
		Point p6 = new Point(7,4);
		Point[] points = {p1,p2,p3,p4,p5,p6};
		
		_149MaxPointsOnALine A =new _149MaxPointsOnALine();
		System.out.println(A.maxPoints(points));
	}

}
