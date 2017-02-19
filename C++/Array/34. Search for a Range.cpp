//
//  34. Search for a Range.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
//          Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//          Your algorithm's runtime complexity must be in the order of O(log n).
//          If the target is not found in the array, return [-1, -1].
//          For example,
//          Given [5, 7, 7, 8, 8, 10] and target value 8,
//          return [3, 4].
//
//  idea:
#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int len=nums.size();
        int min=INT_MIN,max=-1;
        vector<int> save;
        for(int i=0;i<len;i++)
        {
            if(nums[i]==target&&save.size()==0)
            {
                save.push_back(i);
                min=i;
            }
            else if(nums[i]==target&&save.size()==1)
            {
                max=i;
            }
        }//end for
        
        if(save.size()==0)
        {
            save.push_back(-1);
            save.push_back(-1);
        }
        else
        {
            // in case only one targer eliment in the vector.
            if(max<min)
                save.push_back(min);
            else
            save.push_back(max);
        }
        return save;
    }
};

int main(){
    Solution solution;
    vector<int> A={1,3,5};
    int target = 5;
    vector<int> result = solution.searchRange(A,target);
    // 输出
    for(int i = 0;i < result.size();++i){
        cout<<result[i]<<endl;
    }//for
    return 0;
}
