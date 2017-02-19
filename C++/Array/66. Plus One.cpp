//
//  66. Plus One.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/7.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question：
        //Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
        //
        //You may assume the integer do not contain any leading zero, except the number 0 itself.
        //
        //The digits are stored such that the most significant digit is at the head of the list.
        //
        //Subscribe to see which companies asked this question.

//  Idea：use two arrays to record if there if zero in this row/col.

#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if(matrix.empty())
            return;
        int m=matrix.size();
        int n=matrix[0].size();
        
        vector<int>row(m,0);
        vector<int>col(n,0);
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    row[i]=col[j]=1;
            }//for
        
        for(int i=0;i<m;i++)
        {
            if(row[i])
                for(int j=0;j<n;j++)
                    matrix[i][j]=0;
        }//for
        
        for(int j=0;j<n;j++)
        {
            if(col[j])
                for(int i=0;i<m;i++)
                    matrix[i][j]=0;
        }//for
        
    }
};

int main() {
    Solution solution;
    vector<int> row1 = {1,0,3,4};
    vector<int> row2 = {9,4,0,2};
    vector<int> row3 = {6,7,3,4};
    vector<vector<int>> matrix;
    matrix.push_back(row1);
    matrix.push_back(row2);
    matrix.push_back(row3);
    
    solution.setZeroes(matrix);
    int m = matrix.size();
    int n = matrix[0].size();
    for(int i = 0;i < m;i++){
        for(int j = 0;j < n;j++){
            printf("%d ",matrix[i][j]);
        }
        printf("\n");
    }
    return 0;
}
