//
//  54. Spiral Matrix.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/3.
//  Copyright © 2017年 yuebin. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> result;
        
        //see if it is empty
        if(matrix.empty())
            return result;
        
        int rows=matrix.size();
        int cols=matrix[0].size();
        int start_x=0;
        int start_y=0;
        int end_x=cols-1;
        int end_y=rows-1;
        int count=cols*rows;
        int completed=0;
        
        
        //to see if all the points have been visited.
        while(completed<count)
        {
            
            //move towards right
            for(int i=start_x;i<=end_x;i++)
            {
                result.push_back(matrix[start_y][i]);
                completed++;
            }
            start_y++;
            if(start_y>end_y)
                break;
            
            //move downward
            for(int i=start_y;i<=end_y;i++)
            {
                result.push_back((matrix[i][end_x]));
                completed++;
            }
            
            end_x--;
            if(start_x>end_x)
                break;
            
            //move towards left
            for(int i=end_x;i>=start_x;i--)
            {
                result.push_back(matrix[end_y][i]);
                completed++;
            }
            end_y--;
            if(start_y>end_y)
                break;
            
            //move upward
            for(int i=end_y;i>=start_y;i--)
            {
                result.push_back(matrix[i][start_x]);
                completed++;
            }
            
            start_x++;
            if(start_x>end_x)
                break;
            
        }//end while
        
        return result;
        
    }
};

int main(){
    Solution s;
    vector<vector<int> > matrix = {};
    vector<int> result = s.spiralOrder(matrix);
    
    for(int i = 0;i < result.size();++i){
        cout<<result[i]<<"  ";
    }//for
    cout<<endl;
    return 0;
}
