//
//  31. Next Permutation.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//        The replacement must be in-place, do not allocate extra memory.
//        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//          1,2,3 → 1,3,2
//          3,2,1 → 1,2,3
//          1,1,5 → 1,5,1

//  idea: 1) start from the end, find the first index that violate the increasing order. save this index (index)
//        2) start from the end, find the first index that is bigger than that of saved index.
//        3) reverse all the digit that whose index is bigger than the saved index.
#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int len=nums.size();
        if(len<2)
            return;
        int index;
        
        for(index=len-2;index>=0;index--)
        {
            if(nums[index]<nums[index+1])
                break;
        }
        int temp;
        if(index!=-1)
        {
            for(int i=len-1;i>index;i--)
            {
                if(nums[index]<nums[i])
                {
                    temp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
        }//end if
        
        for(int i=index+1,j=len-1;i<j;i++,j--)
        {
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
};


int main(){
    Solution solution;
    vector<int> num={1,3,2};
    // 重新排列
    solution.nextPermutation(num);
    // 输出
    for(int i = 0;i < num.size();i++){
        cout<<num[i];
    }
    cout<<endl;
    return 0;
}
