import java.util.*;
import java.lang.*;

// Rabin Karp
//find if pattern exists in string or not. If found return its index.

public class RabinKarp{

	private int prime = 101;

	public int patternSearch(String s, String pattern){

		int lengthOfPattern = pattern.length();
		long hashOfPattern = createHash(pattern,lengthOfPattern);
		long hashOfString = createHash(s,lengthOfPattern);

		for(int i=0;i<(s.length() - lengthOfPattern + 1);i++){
			
			if(hashOfPattern == hashOfString && checkEqual(pattern,s.substring(i,i+lengthOfPattern),lengthOfPattern))
				return i;
			
			else if ( i != (s.length() - lengthOfPattern) ){
				hashOfString = reCreateHash(s.substring(i+1,i+1+lengthOfPattern), hashOfString, (int)s.charAt(i), lengthOfPattern);
			}

		}
		return -1;
	}
	public boolean checkEqual(String pattern,String substring,int end){
		for(int i=0;i<end;i++){
			if(pattern.charAt(i)!=substring.charAt(i))
				return false;
		}
		return true;
	}

	public long reCreateHash(String pattern,long oldHash,int oldCharAsciiValue, int end){
		long hash=0L;
		hash = oldHash - oldCharAsciiValue;
		hash = hash/prime;
		hash += pattern.charAt(end-1)*Math.pow(prime,end-1);
		return hash;
	}

	public long createHash(String pattern,int end){
		long hash=0L;
		for(int i=0;i<end;i++){
			hash += pattern.charAt(i)*Math.pow(prime,i);
		}
		return hash;
	}
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String s = sc.nextLine();
		System.out.println("Enter a pattern");
		String pattern = sc.nextLine();
		RabinKarp rk = new RabinKarp();
		System.out.println("Staring index of pattern is " + rk.patternSearch(s,pattern));
	}
}