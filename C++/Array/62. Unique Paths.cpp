//
//  59. Spiral Matrix II.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/6.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?

//  idea: the number of path for reaching each grid equals to that of it's left grid's and grid's above it.

#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
        int uniquePaths(int m, int n) {
            int s[m][n];
            for(int i = 0;i < m;++i){
                for(int j = 0;j < n;++j){
                    if(i == 0|| j == 0){
                        s[i][j] = 1;
                    }
                    else{
                        s[i][j] = s[i-1][j] + s[i][j-1];
                    }
                }//for
            }//for
            return s[m-1][n-1];
    }
private:
    
};


int main(){
    Solution s;
    int m = 12;
    int n = 13;
    int result = s.uniquePaths(m,n);
    // 输出
    cout<<result<<endl;
    return 0;
}
