import java.util.*;

class BFS_DFS{

	static class Graph{

		int V;
		LinkedList<Integer> arr[];

		Graph(int V){
			this.V = V;
			arr = new LinkedList[V];

			for(int i=0;i<V;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int src, int dest){
			arr[src].add(dest);
		}

		void BFSTraversal(int head){
			Queue<Integer> q = new LinkedList<Integer>();
			boolean visited[] = new boolean[V];

			System.out.println("BFS traversal of Graph is ");

			q.add(head);
			visited[head]=true;
			while(!q.isEmpty()){
				int current  = q.poll();
				
				System.out.print(current + " ");
				//add all node connected to current node in queue
				for(Integer nodes : arr[current]){
					if(visited[nodes]!=true){
						visited[nodes]=true;
						q.add(nodes);
					}
				}
			}
		}

		void DFSTraversal(int head){
			boolean visited[] = new boolean[V];	
			System.out.println("DFS traversal of Graph is ");

			DFSutil(head,visited);
		}

		void DFSutil(int head,boolean visited[]){
			System.out.print(head + " ");
			visited[head]=true;
			for(Integer nodes : arr[head]){
				if(visited[nodes]!=true){
					DFSutil(nodes,visited);
				}
			}
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        g.BFSTraversal(2);
        System.out.println();
        System.out.println("--------------------");
        g.DFSTraversal(0);
	}
}