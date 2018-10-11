package temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BakeryDairy {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int bakereies = sc.nextInt();
		int dairies = sc.nextInt();
		String input_end = new String();
		HashMap<String, Integer> orderList = new HashMap<>();
		while(input_end != "end"){
			String temp = sc.nextLine();
			System.out.println(temp);
			int num =  sc.nextInt();
			orderList.put(temp, num);
		}
		Set set = orderList.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry mentry = (Map.Entry) it.next();
			System.out.println("key is: " + mentry.getKey() +" & value is: " + mentry.getValue() );
		}
		
	}
}
