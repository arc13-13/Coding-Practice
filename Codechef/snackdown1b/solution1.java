import java.util.*;
import java.io.*;

class solution1{
	public static void main(String[] args) {
		int testcases;
		Scanner sc = new Scanner(System.in);
		testcases = sc.nextInt();
		for(int i=0;i<testcases;i++){
			int num = sc.nextInt();
			if(num == 2010 || num == 2015 || num == 2016 || num == 2017 || num == 2019){
				System.out.println("HOSTED");
			}
			else{
				System.out.println("NOT HOSTED");
			}
		}
	}
}