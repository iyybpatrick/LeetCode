//
//  57. Insert Interval.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/5.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:

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

//  idea:

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
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        int len=intervals.size();
        vector<Interval> result;
        result.push_back(newInterval);
        if(intervals.size()<=0)
            return result;
        
        for(int i=0;i<len;i++)
        {
            Interval back=result.back();
            Interval processing=intervals[i];
            
            if(back.start>processing.end)
            {
                Interval temp=result.back();
                result.pop_back();
                result.push_back(processing);
                result.push_back(temp);
            }
            // delete this element
            else if((back.end>intervals[i].end)&&back.start<intervals[i].start)
                continue;
            // add this element to the rear.
            else if(intervals[i].start>back.end)
                result.push_back(intervals[i]);
            // merge
            else{
                back.end=max(back.end,intervals[i].end);
                back.start=min(back.start,intervals[i].start);
                result.pop_back();
                result.push_back(back);
            }
        }//for
        
        return result;
    }//insert
};

int main(){
    Solution solution;
    Interval in1;
//    Interval in2(3,5);
//    Interval in3(6,7);
//    Interval in4(8,10);
//    Interval in5(12,16);
    
    vector<Interval> vec;
    vec.push_back(in1);
//    vec.push_back(in2);
//    vec.push_back(in3);
//    vec.push_back(in4);
//    vec.push_back(in5);
    
    Interval newInterval;
    // 合并
    vector<Interval> v = solution.insert(vec,newInterval);
    // 输出
    for(int i = 0;i < v.size();i++){
        Interval in = v[i];
        cout<<"["<<in.start<<","<<in.end<<"]"<<endl;
    }//for
    return 0;
}

