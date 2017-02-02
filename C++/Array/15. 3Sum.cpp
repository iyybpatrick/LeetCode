//
//  15. 3Sum.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/23.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.  Note: The solution set must not contain duplicate triplets.

//  idea: if we want to get the answer of a+b+c=0, a simple way is to find b+c=-a. And for searching b+c=-a. I use two pointers moving from both ends to center.

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int i,len,start,end,sum;
        len=nums.size();
        vector<int> triple;
        vector<vector<int>> triples;
        sort(nums.begin(),nums.end());

        for(i=0;i<len-2;i++)
        {
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            sum=-nums[i];
            start=i+1;
            end=len-1;
            int target;
            while(start<end)
            {
                target=nums[start]+nums[end];
                
                //find one answer
                if(sum==target)
                {
                    triple.clear();
                    triple.push_back(nums[i]);
                    triple.push_back(nums[start]);
                    triple.push_back(nums[end]);
                    triples.push_back(triple);
                    
                    //note
                    while(start<end&&nums[start]==nums[start+1])
                        start++;
                        start++;
                    while(start<end&&nums[end]==nums[end-1])
                        end--;
                        end--;
                }// end if
                else if(target<sum)
                {
                    while(start<end&&nums[start]==nums[start+1])
                        start++;
                        start++;
                }
                else {
                    while(start<end&&nums[end]==nums[end-1])
                        end--;
                    end--;
                }
            }//end while
            
        }//end for
        
        return triples;
    }
};


int main()
{
    vector<vector<int>> result;
    Solution solution;
    vector<int> vec;
    vec.push_back(0);
    vec.push_back(0);
    vec.push_back(0);
    
    result = solution.threeSum(vec);
    for(int i = 0;i < result.size();i++){
        for(int j = 0;j < result[i].size();j++){
            printf("%d ",result[i][j]);
        }
        printf("\n");
    }
    return 0;
}
