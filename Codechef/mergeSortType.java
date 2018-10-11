import java.util.*;
//Problem Code: MRGSRT

public class mergeSortType{
	
	void mergeSort(int s,int t,int i,int count){
		int mid = (s + t)/2;
		count = count + 1;
		System.out.println(s + " " + t);
		if(s==t && s==i){
			System.out.println(count);
		}
		if(s<t){
			if(i<=mid)
				mergeSort(s,mid,i,count);
			else
				mergeSort(mid+1,t,i,count);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		for(int k=0;k<testcases;k++){
			int s = sc.nextInt();
			int t = sc.nextInt();
			int i = sc.nextInt();
			if(i>t || i<s){
				System.out.println(-1);
				continue;
			}
			mergeSortType mt = new mergeSortType();
			int count=0;
			mt.mergeSort(s,t,i,count);
			
		}
	}
}