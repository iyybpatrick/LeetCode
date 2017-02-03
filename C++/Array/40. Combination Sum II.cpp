//
//  40. Combination Sum II.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
        //Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
        //
        //Each number in C may only be used once in the combination.
        //
        //Note:
        //All numbers (including target) will be positive integers.
        //The solution set must not contain duplicate combinations.
        //For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
        //A solution set is:
                            //[1, 7],
                            //[1, 2, 5],
                            //[2, 6],
                            //[1, 1, 6]

//  idea: the same as the previous solution.


#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int>path;
        vector<vector<int>>result;
        int len=candidates.size();
        sort(candidates.begin(),candidates.end());
        DFS(candidates,path,0,target,result);
        
        return result;
    }//combinationSum2
    
private:
    void DFS(vector<int>&candidates, vector<int>&path, int start,int target, vector<vector<int>>&result)
    {
        if(target==0)
        {
            result.push_back(path);
            return;
        }
        for(int i=start;i<candidates.size();i++)
        {
            // we do not allow same element in the same layer. if allow, the output of [1,1,2,5] 8  will contains two 1,2,5
            if(i>start&&candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                return;
            path.push_back(candidates[i]);
            DFS(candidates, path, i+1, target-candidates[i], result);
            path.pop_back();
        }
    }
};

int main(){
    Solution solution;
    int target = 8;
    vector<int> vec;
    vec.push_back(10);
    vec.push_back(1);
    vec.push_back(2);
    vec.push_back(7);
    vec.push_back(6);
    vec.push_back(1);
    vec.push_back(5);
    vector<vector<int> > result = solution.combinationSum2(vec,target);
    // 输出
    for(int i = 0;i < result.size();++i){
        for(int j = 0;j < result[i].size();++j){
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}

