import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    int findLeftMostOccurence(int arr[],int l,int r,int key){
        
        int mid;
        
        while(l<r-1){
            //using r-l/2 so that overflow does not occur
            mid = l + (r-l)/2; 
            
            if(arr[mid]>=key)
                r=mid;
            else
                l=mid;
        }
        return r;
    }
    
    int findRightMostOccurence(int arr[],int l,int r,int key){
        
        int mid;
        
        while(l<r-1){
            //using r-l/2 so that overflow does not occur
            mid = l + (r-l)/2; 
            
            if(arr[mid]<=key)
                l=mid;
            else
                r=mid;
        }
        return l;
    }
    
	public static void main (String[] args) {
		//code
		int testcases;
		Scanner sc = new Scanner(System.in);
		testcases = sc.nextInt();
		for(int i=0;i<testcases;i++){
		    int n = sc.nextInt();
		    int key = sc.nextInt();
		    int arr[] = new int[n];
		    
		    //filling array
		    for(int j=0;j<n;j++){
		        arr[j] = sc.nextInt();
		    }
		    
		    GFG g = new GFG();
		    //finding left most occurence of key
		    int l = g.findLeftMostOccurence(arr,-1,n-1,key);
		    
		    //finding right most occurence of key
		    int r = g.findRightMostOccurence(arr,0,n,key);
		    int ans  = (arr[l]==key && arr[r]==key) ? r-l+1 : -1; 
		    System.out.println(ans);
		}
	}
}