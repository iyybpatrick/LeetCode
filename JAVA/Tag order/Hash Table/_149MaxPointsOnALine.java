import java.util.*;
public class _149MaxPointsOnALine {

	public static class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	 public int maxPoints(Point[] points) {
		 if (points == null) return 0;
		 int res = 0;
		 int max = 0;
		 int overlap = 0;
		 Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		 
		 for (int i = 0; i < points.length - 1; i++){
			 map.clear();
			 overlap = 0;
			 max = 0;
			 for (int j = i + 1; j < points.length; j++){
				 int dif_x = points[i].x - points[j].x;
				 int dif_y = points[i].y - points[j].y;
				 if (dif_x == 0 && dif_y == 0){
					 overlap++;
				 }else{
					 int gcd = GetGCD(dif_x, dif_y);
					 if (gcd != 0){
						 dif_x /= gcd;
						 dif_y /= gcd;
					 }
					 if (map.containsKey(dif_x)){
						 map.get(dif_x).put(dif_y, map.get(dif_x).getOrDefault(dif_y, 0) + 1);
					 }else{
						 Map<Integer, Integer> m = new HashMap<>();
						 m.put(dif_y, 1);
						 map.put(dif_x, m);
					 }
					 max = Math.max(max, map.get(dif_x).get(dif_y));
				 }//else
				 res = Math.max(res, max + overlap + 1);
			 }//for j
		 }//for i
		 return res;
	 }
	private int GetGCD(int dif_x, int dif_y) {
		// TODO Auto-generated method stub
		if (dif_y == 0) return dif_x;
		return GetGCD(dif_y, dif_x % dif_y);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_149MaxPointsOnALine A = new _149MaxPointsOnALine();
		Point p1 = new Point(2,8);
		Point p2 = new Point(3,8);
		Point p3 = new Point(4,8);
		Point p4 = new Point(5,8);
		Point []points = {p1,p2,p3,p4};
		System.out.print(A.maxPoints(points));
	}

}
