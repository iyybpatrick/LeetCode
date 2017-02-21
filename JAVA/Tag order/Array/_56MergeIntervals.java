import java.util.*;

public class _56MergeIntervals {
	
	  static public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  } 
	  
	  public List<Interval> merge(List<Interval> intervals) {
	        int len=intervals.size();
	        if(len<=1)
	        	return intervals;
	        Collections.sort(intervals, new Comparator<Interval>(){
	        	public int compare(Interval v1,Interval v2){
	        		return v1.start-v2.start;
	        	}
	        });
	        List<Interval> result=new LinkedList<Interval>();
	        int start=intervals.get(0).start;
	        int end=intervals.get(0).end;
	        for(Interval interval : intervals){
	        	if(interval.start<=end){
	        		end=Math.max(end, interval.end); // update overlapping part.
	        	}//if
	        	else{
	        		result.add(new Interval(start,end)); // add previous one to result.
	        		start=interval.start;  //update pointer
	        		end=interval.end;      //update pointer
	        	}//else
	        }//for
	        
	        // add the last interval
	        result.add(new Interval(start,end));
	        return result;
	    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_56MergeIntervals A=new _56MergeIntervals();
		List<Interval> test=new LinkedList<Interval>();
		test.add(new Interval(1,3));
		test.add(new Interval(2,6));
		test.add(new Interval(8,10));
		test.add(new Interval(15,18));
		List<Interval> result=A.merge(test);
		for(int i=0;i<result.size();i++){
		System.out.println("["+result.get(i).start+"  "+result.get(i).end+"]");
		}
	}
}


//question
		//Given a collection of intervals, merge all overlapping intervals.
		//
		//For example,
		//Given [1,3],[2,6],[8,10],[15,18],
		//return [1,6],[8,10],[15,18].