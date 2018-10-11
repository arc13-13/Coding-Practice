import java.lang.*;
import java.io.*;
class GFG
 {  
    //we want solution of Log(n) time complexity
    public static int findRotatingPoint(int arr[],int l,int r){
        int mid;
        while(l<r-1){
            mid = l + (r-l)/2;
            if(arr[mid]<arr[r])
                r=mid;
            else
                l=mid;
        }
        return r;
    }
    //code
	public static void main (String[] args)
	 {
    	 int T;
    	 Scanner sc = new Scanner(System.in);
    	 T = sc.nextInt();
    	 
    	 for(int i=0;i<T;i++){
    	    
    	    int M = sc.nextInt();
    	    int arr[] = new int[M];
    	    //filling input array
    	    for(int j=0;j<M;j++){
    	        arr[j]=sc.nextInt();
    	    }
    	    
    	    //start writing from here
    	    int point = findRotatingPoint(arr,-1,M-1);
    	    System.out.println(arr[point]);
    	 }
	   
	 }
}