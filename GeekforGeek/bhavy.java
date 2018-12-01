import java.util.*;
import java.io.*;

class bhavy{

	static class Node{
		int data;
		int number;
		ArrayList<Node> child;
		Node(int data, int number){ 
            this.data = data; 
            this.number = number;
            child = new ArrayList<Node>();
        } 
	}
	static void checkChildM(Node arr[],int parent,int value){
		boolean ans=false;
		//System.out.println("parent : " + parent + " value : " + value);
		if(!arr[parent].child.isEmpty()){
			for(Node n : arr[parent].child){
				//System.out.println(n.number);
				ans = ans || checkChild(arr,n.number,value);
			}
		}
		if(ans==false)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	static boolean checkChild(Node arr[],int parent,int value){
		boolean ans=false;
		//System.out.println(arr[parent].data + " I am data");
		if(arr[parent].data==value)
			return true;
		if(!arr[parent].child.isEmpty()){
			for(Node n : arr[parent].child){
				ans = ans || checkChild(arr,n.number,value);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String temp[] = br.readLine().split(" ");

		Node arr[] = new Node[N];
		for(int i=0;i<N;i++){
			arr[i] = new Node(Integer.parseInt(temp[i]),i);
		}

		String temp1[];
		for(int i=0;i<N-1;i++){
			temp1 = br.readLine().split(" ");
			arr[Integer.parseInt(temp1[0])-1].child.add(arr[Integer.parseInt(temp1[1])-1]);
		}

		//printing data
		/*for(int i=0;i<N;i++){
			if(!arr[i].child.isEmpty())
				System.out.println( arr[i].child.get(1).data );
		}*/

		int Q = Integer.parseInt(br.readLine());
		int qType,p,v;
		for(int i=0;i<Q;i++){
			temp1 = br.readLine().split(" ");
			qType = Integer.parseInt(temp1[0]);
			p = Integer.parseInt(temp1[1])-1;
			v = Integer.parseInt(temp1[2]);
			if(qType==1){
				arr[p-1].data=v;
			}
			else{
				checkChildM(arr,p,v);
			}
		}
	}
}