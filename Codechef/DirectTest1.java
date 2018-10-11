import java.util.*;

class DirectTest1{

	static int countEvenSum(int arr[],int n) 
	{ 

    int temp[] = {1, 0}; 
   
    int result = 0, sum = 0; 
 
    for (int i = 0; i <= n - 1; i++) 
    { 
        
        sum = ((sum + arr[i]) % 2 + 2) % 2; 
   
        temp[sum]++; 
    } 

    result = result + (temp[0] * (temp[0] - 1) / 2); 
    result = result + (temp[1] * (temp[1] - 1) / 2); 
  
    return (result); 
} 

	public static void main(String[] args) {
		int testcases;
		Scanner sc = new Scanner(System.in);
		testcases = sc.nextInt();

		for(int i=0;i<testcases;i++){
			int N = sc.nextInt();
			long arr[] = new long[N];

			//input
			for(int j=0;j<N;j++){
				arr[j] = sc.nextLong();
			}
			countEvenSum(arr,arr.length);
		}
	}
}