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

//  idea: I implement incursion to find all the path.

#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    //int path_num=0;
    int uniquePaths(int m, int n) {
        if(m<=0||m<=0)
            return 0;
        
        find_path(m,n,0,0);
        
        return path_num;
    }
private:
    int path_num=0;
    void find_path(int row,int col,int cur_row,int cur_col)
    {
        if((cur_col==col-1)&&(cur_row==row-1))
        {
            path_num++;
            return;
        }
        else if((cur_col==col-1)&&(cur_row<row-1))
        {
            find_path(row,col,cur_row+1,cur_col);
        }
        else if((cur_col<col-1)&&(cur_row==row-1))
        {
            find_path(row,col,cur_row,cur_col+1);
        }
        else{
            find_path(row,col,cur_row+1,cur_col);
            find_path(row,col,cur_row,cur_col+1);
        }
    }
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
