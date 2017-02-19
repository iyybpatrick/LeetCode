//
//  48. Rotate Image.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
    //You are given an n x n 2D matrix representing an image.
    //Rotate the image by 90 degrees (clockwise).

//  idea:  element[i][j]->element[j][n-i-1]

#include <iostream>
#include <stdio.h>
#include <vector>
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int len=matrix.size();
        if(len==1)
            return;
        vector<vector<int>>copy =matrix;
        
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
            {
                matrix[j][len-i-1]=copy[i][j];
            }
        
    }
};

  int main()
{
    Solution obj;
    vector<vector<int>> A={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    obj.rotate(A);
    for(int i=0;i<A.size();i++)
    {for(int j=0;j<A.size();j++)
            cout<<A[i][j]<<" ";
        cout<<endl;
        }
}
