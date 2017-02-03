//
//  41. First Missing Positive.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Given an unsorted integer array, find the first missing positive integer.
        //
        //For example,
        //Given [1,2,0] return 3,
        //and [3,4,-1,1] return 2.
        //
        //Your algorithm should run in O(n) time and uses constant space.

//  Idea: Swap elements to where i+1=nums[i], finally, we find out the element does not mean this law, which would be the final result.

#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int len=nums.size();
        int i=0;
        while(i<len)
        {
            if(nums[i]!=(i+1)&&nums[i]>=1&&nums[i]<=len&&nums[nums[i]-1]!=nums[i])
            {
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
            else i++;
        }
        
        for(i=0;i<len;i++)
            if(nums[i]!=i+1)
                return i+1;
        return len+1;
    }
};

int main(){
    Solution solution;
    vector<int> A = {3,4,-1,1};
    cout<<solution.firstMissingPositive(A)<<endl;
    return 0;
}

