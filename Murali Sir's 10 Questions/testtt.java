

class testtt { 
	

	static int find(int[] price, 
						int n, 
						int k) 
	{ 
		
	
		int[][] profit = new int[k + 1][n + 1]; 


		for (int i = 0; i <= k; i++) 
			profit[i][0] = 0; 

		for (int j = 0; j <= n; j++) 
			profit[0][j] = 0; 

		for (int i = 1; i <= k; i++) 
		{ 
			for (int j = 1; j < n; j++) 
			{ 
				int max = 0; 

				for (int m = 0; m < j; m++){
					max = Math.max(max, price[j] - 
							price[m] + profit[i - 1][m]); 
				} 
				

				profit[i][j] = Math.max(profit[i] [j - 1], 
											max); 
			} 
		} 

		return profit[k][n - 1]; 
	} 

	// Driver code 
	public static void main(String []args) 
	{ 	


		int A[] = new int [1000];
		int i,j,k1,t,n,m,k2;
		t=5; n=8; k1=1;k2=2;

	
		while(t-- > 0){
			
			j=23;
			for(i=0;i<n;++i){
				A[i]=j%97+1;
				j=j*j+2*i*(t+2)+1; if (j<0) j=j*-1;
			}
			System.out.println(n + "\t" + k1 + "\t" + find(A,n,k1));
			System.out.println(n + "\t" + k2 + "\t" + find(A,n,k2));
			//cout<<n<<"\t"<<k1<<"\t"<<find(A,n,k1)<<"\n";  
			//cout<<n<<"\t"<<k2<<"\t"<<find(A,n,k2)<<"\n";
		   
			n=2*n+43; k1+=12;k2+=31; 
			if(n>500) 
				{
					n=925;k1=2; k2=5;
				} 
			if(k2>80) 
				k2=45;	
		}
	} 
} 

// This code is contributed by Anshul Aggarwal. 
