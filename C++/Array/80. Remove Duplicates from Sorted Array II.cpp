//
//  80. Remove Duplicates from Sorted Array II.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/7.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //What if duplicates are allowed at most twice?
        //
        //For example,
        //Given sorted array nums = [1,1,1,2,2,3],
        //
        //Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

//  idea:


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len=nums.size();
        if(len<=1)
            return len;
        
        int count=1;
        int index=1;
        for(int i=1;i<len;i++){
            if(nums[i]==nums[i-1]){
                count++;
                if(count>=3)
                    continue;
            }//if
            else{
                count=1;
            }//else
            nums[index++]=nums[i];
        }//for
        return index;
    }
};

int main(){
    vector<int> A={1,1,1,2,2,2,3,4,4,4};
    Solution s;
    int len=s.removeDuplicates(A);
    cout<<"len="<<len<<endl;
    
    return 0;
}
