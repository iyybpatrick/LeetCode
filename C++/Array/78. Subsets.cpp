//
//  78. Subsets.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/8.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  question:
        //
        //Given a set of distinct integers, nums, return all possible subsets.
        //
        //Note: The solution set must not contain duplicate subsets.
        //
        //For example,
        //If nums = [1,2,3], a solution is:
        //
        //[
        // [3],
        // [1],
        // [2],
        // [1,2,3],
        // [1,3],
        // [2,3],
        // [1,2],
        // []
        //]
//  idea:   traverse

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int len=nums.size();
        vector<int>path;
        vector<vector<int>>result;
        result.push_back(path);
        sort(nums.begin(),nums.end());
        for(int i=1;i<=len;i++)
            DFS(nums,len,i,0,result,path);
        
        return result;
    }
private:
    void DFS(vector<int>&nums,int len,int max,int cur,vector<vector<int>>&result,vector<int>&path){
        // add it to result
        if(path.size()==max){
            result.push_back(path);
            return;
        }//if
        
        for(int i=cur;i<len;i++){
            path.push_back(nums[i]);
            DFS(nums,len,max,i+1,result,path);
            path.pop_back();
        }//for
    }//DFS
};

int main(){
    Solution s;
    vector<int> num = {1,2,2};
    vector<vector<int> > result = s.subsets(num);
    // 输出
    for(int i = 0;i < result.size();++i){
        for(int j = 0;j < result[i].size();++j){
            cout<<result[i][j]<<" ";
        }//for
        cout<<endl;
    }//for
    return 0;
}
