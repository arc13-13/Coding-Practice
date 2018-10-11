import java.util.*;

class alienDictionary{

	static class Graph{

		int V;

		LinkedList<Integer> arr[];

		Graph(int v){
			this.V = v;

			arr = new LinkedList[V];

			for(int i=0;i<v;i++){
				arr[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int src, int dest){
			arr[src].add(dest);
		}

		int getNoOfVertices(){
			return arr.length;
		}

		void topologicalSortUtil(Stack stack, boolean visited[], int vertex){

			visited[vertex]=true;

			if(arr[vertex]!=null){
				for(Integer node : arr[vertex]){
					if(visited[node]==false)
						topologicalSortUtil(stack,visited,node);
				}
			}
			
			stack.push(vertex);
		}

		void topologicalSort(){

			Stack<Integer> stack = new Stack<Integer>();
			boolean visited[] = new boolean[V];

			for(int i=0;i<V;i++){
				visited[i]=false;
			}

			for(int i=0;i<V;i++){
				if(visited[i]==false)
					topologicalSortUtil(stack,visited,i);
			}

			while(!stack.isEmpty()){
				System.out.print((char)('a'+ stack.pop()));
			}

		}
	}

	

	static void findOrder(String words[], int no_of_alphabets){
		Graph g = new Graph(no_of_alphabets);

		for(int i=0;i<words.length-1;i++){

			String word1 = words[i];
			String word2 = words[i+1];

			for(int k=0;k<Math.min(word1.length(),word2.length());k++){
				if(word1.charAt(k)!=word2.charAt(k)){
					g.addEdge(word1.charAt(k)-'a',word2.charAt(k)-'a');
				}
			}

		}

		g.topologicalSort();
	}

	public static void main(String[] args) {
		String words[] = {"caa","aaa","aab"};
		int no_of_alphabets=3;
		findOrder(words,no_of_alphabets);
	}
}