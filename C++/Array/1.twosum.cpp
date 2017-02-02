//
//  1.twosum.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/20.
//  Copyright © 2017 year yuebin. All rights reserved.
//
//  Question:
//  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.

//  idea：a copy vector is for getting index of wanted numbers.Sorting input vector is  to find two wanted numbers within one for loop.


#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;


class Solution
{
public:
    vector<int> TwoSum( vector<int> &input,int target)
    {
        vector<int>result;
        vector<int> copy=input;
        if(input.empty())
            return result;
        int count=input.size();
        sort(input.begin(),input.end());
        int sum;
        for(int i=0,j=count-1;i<j;)
        {
            sum=input[i]+input[j];
            if(sum==target)
                return find_index(copy,input[i],input[j]); //find out results.
            else if(sum>target)
                j--;
            else i++;
        }
        //empty
        return result;
    }

    private:
         /* find out index for targets of output*/
        vector<int> find_index(vector<int> &input,int num1,int num2)
        {
            int index1=0,index2=0;
            bool flag1=false,flag2=false;
            for(int i=0;i<input.size();i++)
            {
                if(flag1==false&&input[i]==num1)
                {
                    flag1=true;
                    index1=i;
                }
                else if(flag2==false&&input[i]==num2)
                {
                    flag2=true;
                    index2=i;
                }
            }//for
            
            // switch if index1 is bigger than index2
            if(index1>index2)
            {
                int temp=index1;
                index1=index2;
                index2=temp;
            }
            vector<int> result;
            result.push_back(index1);
            result.push_back(index2);
            return result;
        }
};


int main(int argc, const char * argv[]) {
    Solution solution;
    vector<int> num;
    num.push_back(1);
    num.push_back(4);
    num.push_back(2);
    num.push_back(7);
    
    int target = 8;
    // find out
    vector<int> vec = solution.TwoSum(num,target);
    // output
    cout<<"Index1->"<<vec[0]<<" Index2->"<<vec[1]<<endl;
         return 0;
}
