//
//  64. Minimum Path Sum.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/6.
//  Copyright © 2017年 yuebin. All rights reserved.
//

#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if(grid.empty())
            return 0;
        int row=grid.size();
        int col=grid[0].size();
        vector<int>sum(grid[0]);
        
        // the first row
        for(int i=1;i<col;i++)
            sum[i]+=sum[i-1];
        
        for(int i=1;i<row;i++)
        {
            sum[0]+=grid[i][0];
            for(int j=1;j<col;j++)
            {
                sum[j]=min(sum[j],sum[j-1])+grid[i][j];
            }//for
        }//for
        return sum[col-1];
    }
};

int main(){
    Solution s;
    vector<vector<int> > grid = {{1,5,3,7},{2,6,4,1},{5,4,6,5}};
    int result = s.minPathSum(grid);
    // 输出
    cout<<result<<endl;
    return 0;
}
