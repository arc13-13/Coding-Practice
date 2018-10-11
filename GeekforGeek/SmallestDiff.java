import java.lang.*;
import java.io.*;
import java.util.*;

//very imp

// find max aj - ai
// for j-l<=i<j for a given l
class SmallestDiff
{
	public static void main(String[] args) {
		int a[] = {3,4,5};
	
		int l=0;
		Deque<Integer> q = new LinkedList<Integer>();

		//main code
		int i=0;
		q.add(i);
		int max = Integer.MIN_VALUE;
		for(int j=1;j<3;j++){

			if(a[j]-a[q.peek()]>max)
				max = a[j] - a[q.peek()];

			while(!q.isEmpty() && (a[q.peekLast()]>a[j]) ){
				q.removeLast();
			}

			q.add(j);

			if(j-(q.peek())>=l)
				q.poll();
		}

		System.out.println(max);

	}
}