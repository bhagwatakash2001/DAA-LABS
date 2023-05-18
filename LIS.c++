#include<iostream>

using namespace std;
void LIS(int arr[], int n) {
    int dp[n];
    int maxLen = 1;

    for (int i = 0; i < n; i++) {
        dp[i] = 1;
        int prev = 0;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = (dp[j] + 1 > dp[i]) ? dp[j] + 1 : dp[i];

                maxLen = (dp[i] > maxLen) ? dp[i] : maxLen;               
                
            }
            
        }
        
    }

   cout<<endl<<"Longgest increasing subsequence :"<<maxLen<<endl;
//    int len = sizeof(dp)/sizeof(dp[0]),x=0;
//    cout<<endl<<"Subsequence is :"<<endl;
//    while(len--){
//     cout<<dp[x++]<<" ";
//    }
}
int main(){
    cout<<endl<<"---Longest Increasing Subsequence---\n\n";
    // int arr[] = {2,-5,3,1,4,9,7} ;
    // int n = sizeof(arr)/sizeof(arr[0]);
    int n,i=0;
    cout<<endl<<"Enter array size :";
    cin>>n;
    int arr[n];
    cout<<endl<<"Enter array elemlents :\n";    
    while(n--){
        cin>>arr[i++];
    }
   
    LIS(arr,sizeof(arr)/sizeof(arr[0]));

    // cout<<endl<<"---End of Program---";
    return 0;
}

//Time complexity - O(n^2)



























/* 
1) In this implementation, we use a vector called dp to keep track of the length of the longest increasing subsequence ending at each index i. We initialize all values in dp to 1, since each element is an increasing subsequence of length 1. 

2)Then, for each element nums[i], we iterate through all elements before it nums[j] and check if nums[i] > nums[j]. 

3) If so, we update dp[i] to be the maximum of its current value and dp[j] + 1, since we can extend the longest increasing subsequence ending at j to include i. 

4) Finally, we keep track of the maximum length of any subsequence we find.*/