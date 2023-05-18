#include <iostream>
// #include <climits>
using namespace std;
 
int LIS(int arr[], int i, int n, int prev)
{
    
    if (i == n) {
        return 0;
    }
 
    
    int excl = LIS(arr, i + 1, n, prev);
 
   
    int incl = 0;
    if (arr[i] > prev) {
        incl = 1 + LIS(arr, i + 1, n, arr[i]);
    }
 
   int res = (incl>excl)?incl:excl ;
    return res ;
}
 
int main()
{
    int arr[] = {2,-5,3,1,4,9,7};
    int n = sizeof(arr) / sizeof(arr[0]);
 
    cout << "The length of the LIS is " << LIS(arr, 0, n, 0);
 
    return 0;
}
























// Base case: nothing is remaining

// case 1: exclude the current element and process the
    // remaining elements

 // case 2: include the current element if it is greater
    // than the previous element in LIS

 // return the maximum of the above two choices