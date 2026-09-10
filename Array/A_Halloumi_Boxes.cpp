#include <bits/stdc++.h>
using namespace std;

// Check whether the array can be sorted using reversals of any subarray
// whose length is at most k.
//Link - https://codeforces.com/problemset/problem/1903/A

bool isDecresingPossible(int arr[], int n, int k){
    if(k == 1){
        //if already sorted then only yes
        bool isSorted = true;
        for (int i = 0; i < n-1; i++)
        {
            if(arr[i] > arr[i+1]) isSorted = false;
        }
        if(isSorted) return true;

        return false;
    }
    return true;
}

int main(){
    int noOfTestCases;
    cin>> noOfTestCases;

    for (int i = 0; i < noOfTestCases; i++)
    {
        int arrSize, k;
        cin>>arrSize>>k;

        int arr[arrSize];
        for (int j = 0; j < arrSize; j++)
        {
            cin>>arr[j];
        }
        
        if(isDecresingPossible(arr, arrSize, k)){
            cout<<"YES\n";
        }else{
            cout<<"NO\n";
        }
    }
    
}