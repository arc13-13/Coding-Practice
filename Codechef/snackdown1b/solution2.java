import java.util.*;
import java.io.*;

class solution2{
	public static void main(String[] args) {
		int testcases;
		Scanner sc = new Scanner(System.in);
		testcases = sc.nextInt();
		for(int i=0;i<testcases;i++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			int num,count=0;
			for(int j=0;j<N;j++){
				num = sc.nextInt();
				if(num!=1)
					count++;
			}
			if(count<=K)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}