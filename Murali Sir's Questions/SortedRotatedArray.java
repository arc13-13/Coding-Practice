package temp;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedRotatedArray {
	public static void main(String arg[]) {
		ArrayList<Integer> a = new ArrayList<>();
		System.out.println("Enter number of elements you want in array");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Enter value for array");
		for (int i = 0; i < number; i++) {
			a.add(sc.nextInt());
		}
		System.out.println("Enter number you want to find");
		int num = getIndex(a, sc.nextInt());
		System.out.println( num > 0 ? "Index is " + num  : "Index not found");
	}

	public static int getIndex(ArrayList<Integer> a, int key) {
		int l = 0;
		int h = a.size() - 1;
		int mid = (l + h) / 2;
		while (key != a.get(mid) && l!=h) {
			if (key < a.get(mid) && key > a.get(l)) {
				h = mid - 1;
				mid = (l + h) / 2;
			} else {
				l = mid + 1;
				mid = (l + h) / 2;
			}
			if(l==h && key!=a.get(mid))
				mid=-1;
		}

		return mid;
	}
}
