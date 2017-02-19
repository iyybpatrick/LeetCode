//
//  79. Word Search.cpp
//  leetcode
//
//  Created by Yuebin Yang on 2017/2/7.
//  Copyright © 2017年 yuebin. All rights reserved.
//
//  question:
        //Given a 2D board and a word, find if the word exists in the grid.
        //
        //The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
        //
        //For example,
        //Given board =
        //
        //[
        // ['A','B','C','E'],
        // ['S','F','C','S'],
        // ['A','D','E','E']
        // ]
        //word = "ABCCED", -> returns true,
        //word = "SEE", -> returns true,
        //word = "ABCB", -> returns false.

//  idea: implement the idea of DFS


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty())
            return false;
        row=board.size();
        col=board[0].size();
         vector<vector<bool>> visited(row,vector<bool>(col,false));
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(DFS(i,j,board,word,visited,0))
                    return true;
            }//for
        }//for
        return false;
    }
private:
    int row;
    int col;
    bool DFS(int m,int n,vector<vector<char>>& board, string word,vector<vector<bool>>visited,int index){
        // not match
        if(word[index]!=board[m][n])
            return false;
        // success
        if(index+1==word.length())
            return true;
        visited[m][n]=1;
        
        
        //move left
        if(n>=1&&visited[m][n-1]!=1)
            if(DFS(m,n-1,board,word,visited,index+1))
               return true;
               
       //move right
       if((n<col-1)&&visited[m][n+1]!=1)
       if(DFS(m,n+1,board,word,visited,index+1))
          return true;
        
        //move upward
        if((m>=1)&&visited[m-1][n]!=1)
            if(DFS(m-1,n,board,word,visited,index+1))
                return true;
        
        //move downward
        if((m<row-1)&&visited[m+1][n]!=1)
            if(DFS(m+1,n,board,word,visited,index+1))
                return true;
        
        // for future visit
        visited[m][n]=0;
        return false;
    }//DFS
};

int main(){
    Solution solution;
    vector<vector<char> > board = {{'A','B','C','E'},{'C','F','C','S'},{'A','D','E','E'}};
    string word = "ABCCFC";
    cout<<"length="<<word.length()<<endl;
    bool result = solution.exist(board,word);
    // 输出
    cout<<result<<endl;
    return 0;
}
