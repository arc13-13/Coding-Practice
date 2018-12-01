import java.util.ArrayList;


class ques10{
	static void printSchedule(int A[], int B[], int n1, int n2, int cost){
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];

		temp1[0] = 1;
		temp2[0] = 2;
		for(int i=1;i<n1;i++){
			int a = A[i-1] + A[i];
			int b = B[i-1] - cost + A[i];
			if(a>b){
				A[i] = a;
				temp1[i] = 1;
				//temp2[i] = 1;
			}
			else{
				A[i] = b;
				temp1[i] = 2;
				//temp2[i] = 2;
			}

			a = B[i-1] + B[i];
			b = A[i-1] - cost + B[i];
			if(a>b){
				B[i] = a;
				//temp1[i] = 2;
				temp2[i] = 2;
			}
			else{
				B[i] = b;
				//temp1[i] = 1;
				temp2[i] = 1;
			}

		}

/*		for(int i=0;i<n1;i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();

		for(int i=0;i<n1;i++){
			System.out.print(B[i] + " ");
		}
		System.out.println();

		for(int i=0;i<n1;i++){
			System.out.print(temp1[i] + " ");
		}
		System.out.println();

		for(int i=0;i<n1;i++){
			System.out.print(temp2[i] + " ");
		}
		System.out.println();*/


		int result=0;
		ArrayList<Integer> track = new ArrayList<Integer>();
		int temp = n1-1;
		if(A[temp]>B[temp]){
			result = A[n1-1];
			track.add(1);
			
			int x = temp1[temp];
			temp--;
			while(temp>=0){
				
				if(temp1[temp]==x){
					track.add(1);
				}
				else if(temp2[temp] == x){
					track.add(2);
				}
				else{
					track.add(temp1[temp]);
					x = temp1[temp];
				}

				temp--;
			}
		}
		else{
			result = B[n1-1];
			track.add(2);
			
			int x = temp2[temp];
			temp--;
			while(temp>=0){
				
				if(temp1[temp]==x){
					track.add(1);
				}
				else if(temp2[temp] == x){
					track.add(2);
				}
				else{
					track.add(temp1[temp]);
					x = temp1[temp];
				}
				temp--;
			}
		}

		System.out.println("The max profit is "+result);

		for(int x = track.size()-1;x>=0;x--){
			System.out.print(track.get(x) + " ");
		}
	}

	public static void main(String[] args) {
		int A[] = {10, 15, 18};
		int B[] = {18, 10, 13};

		int cost = 5;
		printSchedule(A, B, A.length, B.length, cost);
	}
}