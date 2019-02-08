
//find path between two cells in a matrix

import java.util.*;
import java.lang.*;
import java.io.*;
class findPathinMatrix
 {
     
    static class Graph{
        
        int V;
        LinkedList<Integer> adj[];
        
        Graph(int V){
            this.V = V;
            
            adj = new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i] = new LinkedList<Integer>();
            }
        }
        
        public void addEdge(int src,int dest){
            adj[src].add(dest);
        }
        
        public void Df(int src,boolean[] visited){
            visited[src] = true;
            //System.out.println("Node " + src);
            for(Integer node : adj[src]){
                if(visited[node]!=true){
                    Df(node,visited);
                }
            }
        }
        
        public int Dfs(int src,int dest){
            boolean visited[] = new boolean[V*V];
            for(int i=0;i<V*V;i++){
                visited[i] = false;
            }
            Df(src,visited);
            if(visited[dest]==true)
                return 1;
            else
                return 0;
        }
        
    }
    
    public static boolean isSafe(int i,int j,int[][] arr,int M){
        if(i<0 || i>=M || j<0 || j>= M || arr[i][j]==0)
            return false;
        return true;
    }
    
    //code
	public static void main (String[] args) throws Exception
	 {
    	 int T;
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 T = Integer.parseInt(br.readLine());
    	 
    	 for(int i=0;i<T;i++){
    	    
    	    int M = Integer.parseInt(br.readLine());
    	    int arr[][] = new int[M][M];
    	    int count=0;
    	    String temp[] = (br.readLine()).split(" ");
    	    //filling input array
    	    for(int j=0;j<M;j++){
    	        for(int k=0;k<M;k++){
    	            arr[j][k]=Integer.parseInt(temp[count]);
    	            count++;
    	        }
    	    }
    	    
    	    //start writing from here
    	    //creating graph of matrix
    	    Graph g = new Graph(M*M);
    	    int p=0,s=0,d=0;
    	    for(int j=0;j<M;j++){
    	        for(int k=0;k<M;k++){
    	            
    	            if(arr[j][k] != 0){
    	                if(isSafe(j,k+1,arr,M))
    	                    g.addEdge(p,p+1);
    	                if(isSafe(j,k-1,arr,M))
    	                    g.addEdge(p,p-1);
    	                if(isSafe(j-1,k,arr,M))
    	                    g.addEdge(p,p-M);
    	                if(isSafe(j+1,k,arr,M))
    	                    g.addEdge(p,p+M);
    	            }
    	            
    	            if(arr[j][k]==1)
    	                s=p;
    	            if(arr[j][k]==2)
    	                d=p;
    	            p++;
    	        }
    	    }
    	    System.out.println(g.Dfs(s,d));
    	 }
	   
	 }
}