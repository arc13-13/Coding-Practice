import java.util.*;

class UnionFind_DisjointSet{

	static class Graph{

		int V,E;
		Edge arr[];

		class Edge{
			int src,dest;
		}

		Graph(int v,int e){
			this.V = v;
			this.E = e;

			arr = new Edge[E];

			for(int i=0;i<E;i++){
				arr[i] = new Edge();
			}
		}

		int find(int parent[],int i){
			if(parent[i]==-1){
				return i;
			}
			return find(parent,parent[i]);
		}

		void union(int parent[],int x,int y){
			int xset = find(parent,x);
			int yset = find(parent,y);
			parent[xset]=yset;
		}

		int isCycle(){
			int parent[] = new int[V];

			//initializing all parent with -1
			for(int i=0;i<V;i++){
				parent[i]=-1;
			}

			for(Edge e : arr){

				//System.out.println(" aa " + e.src + " " + e.dest);
				//check if src and dest of e have same parent or not
				int x = find(parent,e.src);
				int y = find(parent,e.dest);

				System.out.println(x + " " + y);
				if(x==y)
					return 1;

				union(parent,x,y);
			}

			return 0;
		}
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(3,3);

		g.arr[0].src = 0;
		g.arr[0].dest = 1;

		g.arr[1].src = 1;
		g.arr[1].dest = 2;

		g.arr[2].src = 2;
		g.arr[2].dest = 0;

		System.out.println(g.isCycle()==1?"Cycle found":"Cycle not found");

		
	}
}