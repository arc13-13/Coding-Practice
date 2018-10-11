import java.util.*;
import java.io.*;
import java.math.BigInteger;
class test{

	void mainLogic(BigInteger num,int m){
		int var=1;
		int temp1=0;
		int temp2=0;
		int temp3=0;
		//int n = arr.length-1;
		String s = new String();
		int flag=0;
		while(num.compareTo(BigInteger.ZERO)>0){

			//function
			temp1 = (var*var)%m;
			temp2 = (5*var)%m;
			temp3 = (temp1 + temp2)%m;
			var = (temp3 + 6)%m;

			//finding pattern
			if(flag==1 && Integer.valueOf(s.charAt(0)+"").equals(var)){
				break;
			}
			flag=1;
			s=s+var;
			//decreaseNumber;
			num = num.subtract(BigInteger.ONE);

		}

		//System.out.println(s);
		int index = (num.mod(BigInteger.valueOf(s.length()))).intValue();
		System.out.println(s.charAt(index));

	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("1000digitNum.txt"));

		String n = br.readLine();
		BigInteger num = new BigInteger(n);
		
		//System.out.println(n);
		test t = new test();
		t.mainLogic(num,10);
	}
}