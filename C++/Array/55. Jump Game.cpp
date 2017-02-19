//
//  55. Jump Game.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/4.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Given an array of non-negative integers, you are initially positioned at the first index of the array.
        //Each element in the array represents your maximum jump length at that position.

        //Determine if you are able to reach the last index.
        //For example:
        //A = [2,3,1,1,4], return true.
        //A = [3,2,1,0,4], return false.
#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    bool canJump(vector<int>& nums) {
        int distance=0;
        int len=nums.size();
        
        for(int i=0;i<len&&i<=distance;i++)
        {
            distance=max(distance,nums[i]+i);
        }
        
        if(distance<len-1)
        return false;
        else return true;
    }
};

int main()
{
    Solution obj;
    vector<int> A={2,2,1,0,1};
    bool a=obj.canJump(A);
    cout<<a<<endl;
}
