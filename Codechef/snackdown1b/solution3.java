import java.util.*;
import java.io.*;

class solution3{
	public static void main(String[] args) throws Exception {
		int testcases;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcases = Integer.parseInt(br.readLine());
		for(int t=0;t<testcases;t++){
			String temp[] = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			int K = Integer.parseInt(temp[2]);
			int L = Integer.parseInt(temp[3]);

			String temp1[] = (br.readLine()).split(" ");
			int input[] = new int[N];
			HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
			for(int i=0;i<N;i++){
				input[i] = Integer.parseInt(temp1[i]);
				hmap.put(input[i],1);
			}

			//sort input
			int count=0;
			M = M * L;
			int before=Integer.MAX_VALUE;
			for(int i=1;i<=K;i++){
				
				M--;
				if((M + L)<before)
					before=M+L;

				count++;
				
				if(hmap.containsKey(count)==true){
					M = M + L;
				}
				
			}
			System.out.println(before);
		}
	}
}