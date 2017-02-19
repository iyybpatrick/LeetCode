//
//  39. Combination Sum.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
        //
        //The same repeated number may be chosen from C unlimited number of times.
        //
        //Note:
        //All numbers (including target) will be positive integers.
        //The solution set must not contain duplicate combinations.
        //For example, given candidate set [2, 3, 6, 7] and target 7,
        //A solution set is:
                //[7],
                //[2, 2, 3]

//  idea: because every element maybe used for more than one time. I use recursion to find out all the possible solutions.

#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        vector<vector<int>>result;
        int len=candidates.size();
        sort(candidates.begin(),candidates.end());
        DFS(candidates,path,0,target,result);
        
        return result;
    }// combinationSum
    
private:
    void DFS(vector<int>& candidates,vector<int>& path,int start,int target,vector<vector<int>>& result)
    {
        if(target==0)
        {
            result.push_back(path);
            return;
        }
        for(int i=start;i<candidates.size();i++)
        {
            if(candidates[i]>target)
                return;
            path.push_back(candidates[i]);
            DFS(candidates, path, i, target-candidates[i], result);
            path.pop_back();
        }
    }// DFS
};


int main(){
    Solution solution;
    int target = 12;
    vector<int> vec;
    vec.push_back(2);
    vec.push_back(4);
    //vec.push_back();
    vec.push_back(8);
    
    vector<vector<int> > result = solution.combinationSum(vec,target);
    // 输出
    for(int i = 0;i < result.size();++i){
        for(int j = 0;j < result[i].size();++j){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
