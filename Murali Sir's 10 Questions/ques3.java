import java.util.*;

/*In transitive closure,along with mintaing a boolean matrix for reachability,
	we maintain an extra matrix for W(j)-W(i)*/

class ques3{
	static void transitiveclosure(Graph g){
		int n = g.getAllVertices().size();
		int mat[][] = new int[n][n];
		boolean temp[][] = new boolean[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				mat[i][j] = -1;
				temp[i][j] = false;
			}
		}

		//creating the matrix from the graph
		//here mat[i][j] store the value of the node i if j is connected to i
		//temp[i][j] stores true if i is connected to j
		for(int i=0;i<n;i++){
			Vertex<Integer> current = g.getVertex(i);
			ArrayList<Edge<Integer>> al= current.getEdges();
			Iterator it = al.iterator();
			while(it.hasNext()){
				Edge<Integer> e = (Edge<Integer>) it.next();
				Vertex<Integer> v = getVertexForEdge(e,current);
				int id = (int) v.getId();
				mat[i][id] = current.getData();
				temp[i][id] = true;
			}
		}
/*
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}*/

		int result[][] = new int[n][n];

		//initializing result 
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				result[i][j] = mat[i][j];
			}
		}

		//if temp[i][j] is true that means i is directly connected to j so result[i][j] 
		//contains value of node j - mat[i][j](which is value of node i)

		//else if temp[i][k] && temp[k][j] is true then i is connected to j via k so result[i][j] 
		//contains value of node j - mat[i][k](which is value of node i)
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(temp[i][j]==true)
						result[i][j] = (int) g.getVertex(j).getData() - mat[i][j];
					else if((temp[i][k] && temp[k][j]) == true)
						result[i][j] = (int) g.getVertex(j).getData() - mat[i][k];
				}
			}
		}

/*		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}*/


		//finding the max value in the matrix result
		int max = Integer.MIN_VALUE;
		int start=-1,end=-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(result[i][j] > max){
					max = result[i][j];
					start = i;
					end = j;
				}
			}
		}
		System.out.println("The max value is " + max +" from vertex " + start + " to vertex " + end);

	}

	static Vertex<Integer> getVertexForEdge(Edge<Integer> e,Vertex<Integer> v1){
		Vertex<Integer> x = e.getVertex1();
		Vertex<Integer> y = e.getVertex2();
		return x.equals(v1) ? y : x;
	}

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>(true);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,4);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(4,3);

		g.setDataForVertex(0,2);
		g.setDataForVertex(1,3);
		g.setDataForVertex(2,5);
		g.setDataForVertex(3,4);
		g.setDataForVertex(4,6);

		transitiveclosure(g);
	}
}