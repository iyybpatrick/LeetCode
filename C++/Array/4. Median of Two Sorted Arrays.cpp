//
//  4. Median of Two Sorted Arrays.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/1/21.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  Question:
//  There are two sorted arrays nums1 and nums2 of size m and n respectively.
//  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

//  idea：assume the index of wanted number is k, input vectors are a and b, everytime I compare the first number in these two vectors and delete the lesser one. At the same time, k also minus one until it gets 0.


#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int number1=nums1.size();
        int number2=nums2.size();
        if(number1==0&&number2==0)
            return -1;
        
        int total =number1+number2;
        if(total%2!=0)
        {
            return find_kth(nums1,number1, nums2,number2, total/2+1);
        }
        else
        {
            double a=find_kth(nums1, number1,nums2,number2, total/2);
            double b=find_kth(nums1,number1, nums2,number2, total/2+1);
            //cout<<"aa="<<a<<" bb="<<b<<endl;
            return (a+b)/2;
        }
    }
private:
    double find_kth(vector<int>&nums1, int number1, vector<int>&nums2, int number2, int k)
    {
        vector<int>::iterator a = nums1.begin();
        vector<int>::iterator b = nums2.begin();
       //cout<<"aa="<<*a<<" bb="<<*b<<endl;
        
        while((a!=nums1.end())&&(b!=nums2.end())&&(k!=1))
        {
            
            if(*a<*b)
            {
                a++;
                k--;
               //cout<<"a="<<*a<<" "<<"k="<<k<<endl;
            }
            else{
                b++;
                k--;
               //cout<<"b="<<*b<<" "<<"k="<<k<<endl;
            }
        }
        
        if(a==nums1.end())
        {
            b=b+k-1;
            return *b;
        }
        if(b==nums2.end())
        {
            a=a+k-1;
            return *a;
        }
        
        if(k==1)
        return min(*a,*b);
        
        return 0;
    }
};

int main(){
    Solution obj;
    vector<int>num1={1,3,5,8};
    vector<int>num2={2,4};
    double a=obj.findMedianSortedArrays(num1, num2);
    cout<<"a="<<a<<endl;
}
