//
//  27. Remove Element.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/28.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:Given an array and a value, remove all instances of that value in place and return the new length.
//   Do not allocate extra space for another array, you must do this in place with constant memory.
//   The order of elements can be changed. It doesn't matter what you leave beyond the new length.

#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int len=nums.size();
        int new_len=0;
        sort(nums.begin(),nums.end());
        for(int i=0;i<len;i++)
        {
            if(nums[i]==val)
                continue;
            nums[new_len]=nums[i];
            new_len++;
        }
        return new_len;
    }
};

int main() {
    Solution solution;
    int result;
    vector<int> A = {3,2,2,3};
    result = solution.removeElement(A,3);
    for(int i = 0;i < result;i++){
        printf("%d ",A[i]);
    }
    printf("\nLength:%d\n",result);
    return 0;
}
