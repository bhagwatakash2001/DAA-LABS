import java.util.*;
class MergeSort {  
     
    void merge(int a[], int beg, int mid, int end)    
    {    
        int i, j, k;  
        int n1 = mid - beg + 1;    
        int n2 = end - mid;    
          
      
            int LeftArray[] = new int[n1];  
            int RightArray[] = new int[n2];  
          
         
        for (i = 0; i < n1; i++)    
        LeftArray[i] = a[beg + i];  

        for (j = 0; j < n2; j++)    
        RightArray[j] = a[mid + 1 + j];    
          
        i = 0;  
        j = 0;   
        k = beg;  
          
        while (i < n1 && j < n2)    
        {    
            if(LeftArray[i] <= RightArray[j])    
            {    
                a[k] = LeftArray[i];    
                i++;    
            }    
            else    
            {    
                a[k] = RightArray[j];    
                j++;    
            }    
            k++;    

            
        }    
        while (i<n1)    
        {    
            a[k] = LeftArray[i];    
            i++;    
            k++;    
        }    
          
        while (j<n2)    
        {    
            a[k] = RightArray[j];    
            j++;    
            k++;    
        }    

        System.out.println("\nPass "+n1+","+n2);
        System.out.println("LeftArray-"+Arrays.toString(LeftArray));
        System.out.println("RightArray-"+Arrays.toString(RightArray));

    }    
      
    void mergeSort(int a[], int beg, int end)  
    {  
        if (beg < end)   
        {  
            int mid = (beg + end) / 2;  
            mergeSort(a, beg, mid);  
            mergeSort(a, mid + 1, end);  
            merge(a, beg, mid, end);  
        }  
    }  
      
     
    void printArray(int a[], int n)  
    {  
        int i;  
        for (i = 0; i < n; i++)  
            System.out.print(a[i] + " ");  
    }  
      
    public static void main(String args[])  
    {  
         
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size-");
        int n = sc.nextInt();
        int a[] = new int[n];  

        System.out.println("Enter Elements-");

        for(int i = 0; i < n; i++) 
        a[i] = sc.nextInt(); 

        MergeSort m1 = new MergeSort(); 


        System.out.println("\nMerge Sort-");  
        System.out.println("\nBefore sorting -");  

        m1.printArray(a, n);  
        
        m1.mergeSort(a, 0, n - 1);  

        System.out.println("\nAfter sorting -");  
        m1.printArray(a, n);  
        
    }  
      
}  



//O(nLogn)