import java.*;
// MaxHour is given. MaxPerDay is given. So we are given a week and we have to complete maxHour work. We can only
// work upto maxPerDay hours. Now a string of week work is given. We have to do remaining work for "?". Print all
// possibilities.
public class workPossibilities{
	

	public static void main(String arg[]){
		int maxHour = 20;
		int maxPerDay = 8;
		String s = "080?0??";
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '?')
				count++;
			else
				maxHour = maxHour - Character.getNumericValue(s.charAt(i));
		}
		count =(int) Math.pow(10,count);
		for(int i=0;i<count;i++){
			String temp = Integer.toString(i);
			int sum=0;
			for(int j=0;j<temp.length();j++){
				sum = sum + Character.getNumericValue(temp.charAt(j));
				if(sum>8)
					break;
			}
			if(sum == maxHour)
				System.out.println("Possibility " + i);
		}

	}
}