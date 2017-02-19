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

//  idea:  search from top right corner.


#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if(matrix.empty()){
            return false;
        }//if
        int row = matrix.size();
        int col = matrix[0].size();
        int x = 0,y = col - 1;
        // search from top right corner
        while(x < row && y >= 0){
            if(matrix[x][y] == target){
                return true;
            }//if
            else if(matrix[x][y] < target){
                ++x;
            }//else
            else{
                --y;
            }
        }//while
        return false;
    }
};  int main(){
    Solution s;
    int target = 6;
    vector<vector<int> > matrix = {{}};
    
    bool result = s.searchMatrix(matrix,target);
    // 输出
    cout<<result<<endl;
    return 0;
}
