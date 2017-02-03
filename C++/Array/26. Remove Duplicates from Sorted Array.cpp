//
//  26. Remove Duplicates from Sorted Array.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:Given input array nums = [1,1,2], Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len=nums.size();
        int new_len=0,i;
        
        for(i=0;i<len;i++)
        {
            // skip duplicate
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            nums[new_len]=nums[i];
            new_len++;
        }//end for
        return new_len;
    }
};
int main() {
    int result;
    Solution solution;
    vector<int> A={1,1,2};
    result = solution.removeDuplicates(A);
    printf("Length:%d\n",result);
    for(int i = 0;i < result;i++){
        printf("%d ",A[i]);
    }
    return 0;
}
