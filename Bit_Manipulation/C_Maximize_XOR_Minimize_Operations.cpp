#include <bits/stdc++.h>
using namespace std;

// Given x and y, each operation transfers 1 from x to y.
// Maximize x XOR y, and among all maximum-XOR outcomes, minimize the number of operations.
//Link - https://codeforces.com/contest/2260/problem/C

pair<int,int> func(int a, int b){
    //We want to minimize this k
    int k = a;          //Number that is subtracted from a to make a^b greatest
    int sum = a+b;

    //Extracting most significant bit to the least significant bit
    for(int bit=30; bit>=0; bit--){
        int currBit = (sum>>bit)&1;
        if(currBit == 1){
            if(k >= pow(2,bit)){
                k = k - pow(2,bit);
            }
        }
    }
    return {a+b,k};
}

int main(){
    int noOfTestCases;
    cin>> noOfTestCases;

    for (int i = 0; i < noOfTestCases; i++)
    {
        int a, b;
        cin>>a>>b;

        pair<int,int> result = func(a,b);
        cout<<result.first<<" "<<result.second<<"\n";
    }
    
}