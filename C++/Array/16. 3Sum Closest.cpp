//
//  16. 3Sum Closest.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/24.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
//  Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//  idea: almost the same with the previous question.


#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int sum,i,start,end,result,closest_val,min_val=INT_MAX;
        int len=nums.size();
        sort(nums.begin(),nums.end());
        
        for(i=0;i<len-2;i++)
        {
            start=i+1;
            end=len-1;
            while(start<end)
            {
                sum=nums[i]+nums[start]+nums[end];
                closest_val=abs(sum-target);
                
                // because it said we assume only one result, so just return.
                if(sum==target)
                {
                    return sum;
                }
                
                // we need to update if we have find closer result.
                if(closest_val<min_val)
                {
                    min_val=closest_val;
                    result=sum;
                    
                }
                
                if(sum<target)
                {   while(start<end&&nums[start]==nums[start+1])
                            start++;
                            start++;
                }
                else
                {
                     while(start<end&&nums[end]==nums[end-1])
                            end--;
                            end--;
                }
                
            }//end while
        }//end for
        return result;
        
    }
};

int main() {
    int result;
    Solution solution;
    vector<int> vec;
    vec.push_back(-3);
    vec.push_back(-2);
    vec.push_back(-5);
    vec.push_back(3);
    vec.push_back(-4);
    result = solution.threeSumClosest(vec,-1);
    printf("Target:%d\n",result);
    return 0;
}
