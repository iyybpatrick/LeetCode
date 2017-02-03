//
//  53. Maximum Subarray.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
        //For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
        //the contiguous subarray [4,-1,2,1] has the largest sum = 6.

//  idea:

#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int len=nums.size();
        int max=0;
        int sum=0;
        
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                
            }
        }
    }
};
