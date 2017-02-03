//
//  18. 4sum.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/27.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.  Note: The solution set must not contain duplicate quadruplets.

//  idea: fix two numbers and find the other two numbers sothat the sum equals to target. Then it becomes the previous question. I tried a manual way to remove duplicate by skiping duplicate numbers; but actually it pretty hard to realize. Because desired output maybe like this [0,0,0,0], [-1,-1,-1,3]. So finally I tried to use set to remove duplicate.


#include <iostream>
#include <stdio.h>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int i,j,sum,start,end;
        int len=nums.size();
        vector<int> quadruplet;
        vector<vector<int>>quadruplets;
        set<vector<int>> sets;
        sort(nums.begin(),nums.end());
        for(i=0;i<len-3;i++)
        {
            //skip duplicate
            if(i!=0&&(nums[i]==nums[i-1]))
                continue;
            for(j=i+1;j<len-2;j++)
            {
                //skip duplicate
                if(j!=i+1&&(nums[j]==nums[j-1]))
                    continue;
                start=j+1;
                end=len-1;
                while(start<end)
                {
                    sum=nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target)
                    {
                        quadruplet.clear();
                        quadruplet.push_back(nums[i]);
                        quadruplet.push_back(nums[j]);
                        quadruplet.push_back(nums[start]);
                        quadruplet.push_back(nums[end]);
                        sets.insert(quadruplet);
                        start++;
                        end--;
                        // to prevent duplicate, I skip duplicate elements.
                        //while(start<end && nums[start]==nums[start+1]) start++; start++;
                        //while(start<end && nums[end]==nums[end-1]) end--;end--;
                    }
                    else if(sum<target)
                    {
                        //while(start<end && nums[start]==nums[start+1]) start++; start++;
                        start++;

                    }
                    else{
                        //while(start<end && nums[end]==nums[end-1]) end--;end--;
                        end--;
                    }
                }//end while
            }// end for
        }//end for
        
        set<vector<int>>::iterator it=sets.begin();
        for(;it!=sets.end();it++)
            quadruplets.push_back(*it);
        
        
        return quadruplets;
    }//four sum
};




int main() {
    vector<vector<int>> result;
    Solution solution;
    vector<int> vec;
    vec.push_back(-3);
    vec.push_back(-3);
    vec.push_back(-2);
    vec.push_back(-1);
    vec.push_back(0);
    vec.push_back(0);
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(3);
    vec.push_back(3);
    result = solution.fourSum(vec,0);
    for(int i = 0;i < result.size();i++){
        for(int j = 0;j < result[i].size();j++){
            printf("%d ",result[i][j]);
        }
        printf("\n");
    }
    return 0;
}
