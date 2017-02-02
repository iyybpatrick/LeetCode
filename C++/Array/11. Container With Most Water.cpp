//
//  11. Container With Most Water.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/22.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:s
//  Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.   Note: You may not slant the container and n is at least 2.

//  idea: there are two index pointing at the beginning and at the end of of vector. Everytime I update the maxinum area and compare the value of these two index. the smaller one moves one cell towards center.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        if(height.size()<2)
            return 0;
        int j=height.size()-1;
        int i=0;
        int area=0,maxarea=0;
        for(;i<j;)
        {
            if(height[i]<height[j])
            {
                area=(j-i)*height[i];
                i++;
            }
            else{
                area=(j-i)*height[j];
                j--;
            }
            if(maxarea<area)
            {
                maxarea=area;
            }
        }// end of for
        
        return maxarea;
    }
};

int main()
{
    vector<int> height;
    height.push_back(2);
    height.push_back(3);
    height.push_back(1);
    height.push_back(4);
    height.push_back(2);
    Solution obj;
    int max=obj.maxArea(height);
    cout<<"max="<<max<<endl;
    return 0;
}
