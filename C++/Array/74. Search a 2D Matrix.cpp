//
//  74. Search a 2D Matrix.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/7.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  question:
        //
        //Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        //
        //Integers in each row are sorted from left to right.
        //The first integer of each row is greater than the last integer of the previous row

//  idea:  search from bottom.


#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int i,j;
        int m=matrix.size();
        int n=matrix[0].size();
        if(n==0)
            return false;
        // search from bottom
        for(i=m-1;i>=0;i--){
            // above
            if(target<matrix[i][0]){
                continue;
            }//if
            for(int j=0;j<n;j++){
                if(target==matrix[i][j]){
                    return true;
                }//if
                return false;
            }//for
        }//for
        return false;
    }
};
int main(){
    Solution s;
    int target = 6;
    vector<vector<int> > matrix = {{}};
   
    bool result = s.searchMatrix(matrix,target);
    // 输出
    cout<<result<<endl;
    return 0;
}
