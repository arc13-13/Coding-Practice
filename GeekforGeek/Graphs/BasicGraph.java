import java.util.*;

class BasicGraph{

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
			arr[src].add(dest);
			arr[dest].add(src);
		}

		void printGraph(){
			for(int v=0;v<V;v++){
				System.out.println("Adjacency list of vertex " + v);
				System.out.print("head");
				for(Integer nodes : arr[v]){
					System.out.print( "-->" + nodes);
				}
				System.out.print("\n");
			}
		}

	}


	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,4);
		g.addEdge(3,4);
		g.addEdge(3,1);
		g.printGraph();
	}
}