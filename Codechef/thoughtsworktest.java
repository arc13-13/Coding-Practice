import java.util.*;
import java.io.*;

class thoughtsworktest{

	static class Graph{

		int V=0;
		//array of LinkedList
		LinkedList<Integer> arr[];

		Graph(int V){
			this.V = V;

			arr = new LinkedList[V];

			for(int i=0;i<V;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int src, int dest){
			//as it is non directed graph
			arr[src].addFirst(dest);
			arr[dest].addFirst(src);
		}
		
		boolean[] findPath(int u,int v,int N){
			boolean visited[] = new boolean[N];	
			DFSutil(u,visited,v);
			System.out.println();
			return visited;

		}

		void DFSutil(int head,boolean visited[],int v)
		{
				System.out.print(head + " ");
				visited[head]=true;
				if(head==v)
					return;
				for(Integer nodes : arr[head]){
					
					if(visited[nodes]!=true){
						DFSutil(nodes,visited,v);
						if(visited[v]==true){
							break;
						}
						visited[nodes]=false;
					}
				}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		for(int i=0;i<testcases;i++){
			int N = Integer.parseInt(br.readLine());
			Graph g = new Graph(N);
			String temp[];
			for(int j=0;j<N-1;j++){
				temp = br.readLine().split(" ");
				g.addEdge(Integer.parseInt(temp[0])-1,Integer.parseInt(temp[1])-1);
			}
			temp = br.readLine().split(" ");
			int u=Integer.parseInt(temp[0])-1;
			int v=Integer.parseInt(temp[1])-1;
			boolean visited[] = g.findPath(u,v,N);
			for(int k=0;k<N;k++){
				System.out.println(k + " : " + visited[k]);
			}
		}
	}
}