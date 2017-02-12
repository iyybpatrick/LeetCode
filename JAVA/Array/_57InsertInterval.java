import java.util.*;
public class _57InsertInterval {

	static public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
       if( intervals.size()==0){
    	   intervals.add(newInterval);
    	   return intervals;
       }
       List<Interval> result=new LinkedList<>();
       int i=0;
       //add intervals that before newInterval's start
       while(i<intervals.size()&&intervals.get(i).end<newInterval.start){
    	   result.add(intervals.get(i++));
       }//while
       
       //merge and add newInterval   
       while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
    	   newInterval.start=Math.min(newInterval.start,intervals.get(i).start); 
    	   newInterval.end=Math.max(newInterval.end, intervals.get(i).end);
    	   i++;
       }//while
       result.add(newInterval);     
       //add intervals that after newInterval's end
       while(i<intervals.size()){
    	   result.add(intervals.get(i++));
       }//while
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_57InsertInterval A=new _57InsertInterval();
		List<Interval> test=new LinkedList<>();
		List<Interval> result=new LinkedList<>();
		test.add(new Interval(0,1));
		//test.add(new Interval(6,9));
		Interval newInterval=new Interval(2,5);
		result=A.insert(test, newInterval);
		for(int i=0;i<result.size();i++){
			System.out.println("["+result.get(i).start+"  "+result.get(i).end+"]");
			}
	}

}

//question:
		//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
		//
		//You may assume that the intervals were initially sorted according to their start times.
		//
		//Example 1:
		//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		//
		//Example 2:
		//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
		//
		//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].