import java.util.*;
import java.lang.*;

public class TurnPiker_1_4{
	
	public Stack getArray(LinkedList<Integer> diff,Stack points,int number){

		for(int i=0;i<number;i++){
			int temp1 = diff.get(i);
			Iterator it = points.iterator();
			while(it.hasNext()){
				int absDifference = Math.abs( ((int)it.next()) - temp1);
				
			}
		}

		return points;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in array");
		int number = sc.nextInt();
		LinkedList<Integer> diff = new LinkedList<Integer>();
		Stack points = new Stack();
		points.push(0);
		for(int i=0;i<number;i++){
			diff.add(sc.nextInt());
		}

		Collections.sort(diff);
		TurnPiker_1_4 tp = new TurnPiker_1_4();
		tp.getArray(diff,points,number);

	}
}