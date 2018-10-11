import java.util.*;
import java.lang.*;

// Longest length susbstring which repeats atleast K times.

public class Assignment1_3{
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String s = sc.nextLine();
		int flag=0;
		System.out.println("Number of times pattern need to be present");
		int k = sc.nextInt();

		int logestLengthPossibleOfSubstring = s.length() - k + 1;
		String pattern = new String();
		for(int i=logestLengthPossibleOfSubstring;i>0;i--){
			for(int j=0;j<s.length()-i+1;j++){

				pattern = s.substring(j,j+i);
				Assignment1_2 rk = new Assignment1_2();
				if(rk.patternSearch(s,pattern,k) == "True"){
					System.out.println("Longest length is " + i);
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==0)
			System.out.println("Not Found");
	}
}