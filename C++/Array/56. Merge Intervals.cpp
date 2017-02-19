//
//  56. Merge Intervals.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/5.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Given a collection of intervals, merge all overlapping intervals.
        //
        //For example,
        //Given [1,3],[2,6],[8,10],[15,18],
        //return [1,6],[8,10],[15,18].

//  idea: I first sort intervals by their start times. then merge or not.

#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

  struct Interval {
      int start;
      int end;
      Interval() : start(0), end(0) {}
      Interval(int s, int e) : start(s), end(e) {}
  };

class Solution {
public:
    
    static bool cmp(struct Interval &inter1,struct Interval &inter2)
    {
        return inter1.start<inter2.start;
    }
    vector<Interval> merge(vector<Interval>& intervals) {
        
        int len=intervals.size();
        if(len<=1)
            return intervals;
        vector<Interval> result;
        sort(intervals.begin(),intervals.end(),cmp);
        result.push_back(intervals[0]);
        for(int i=1;i<len;i++)
        {
            struct Interval processing=intervals[i];
            struct Interval rear=result.back();
            if(processing.start<=rear.end&&processing.end>rear.end)
            {
                result.pop_back();
                rear.end=processing.end;
                result.push_back(rear);
            }
            else if(rear.end<processing.end)
            {
                result.push_back(processing);
            }
            
        }
        return result;
    }
};

int main()
{
    Solution obj;
    struct Interval interval2(2,6),interval3(8,10),interval1(1,3),interval4(15,18);
    
    vector<Interval> intervals,result;
    intervals.push_back(interval1);
    intervals.push_back(interval2);
    intervals.push_back(interval3);
    intervals.push_back(interval4);
    result=obj.merge(intervals);
    for(int i=0;i<result.size();i++)
        cout<<result[i].start<<" "<<result[i].end<<endl;
    
    
}
