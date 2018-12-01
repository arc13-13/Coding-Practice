import java.util.*;

class ques2 {
	static final int INF = Integer.MAX_VALUE;

	static void flloydwarshall(int distancematrix[][], int rows, int cols){
		int distance[][] = new int[rows][cols];
		int path[][] = new int [rows][cols];

		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				distance[i][j] = distancematrix[i][j];
				if(distancematrix[i][j] != INF && i!=j)
					path[i][j] = i;
				else
					path[i][j] = -1;
			}
		}

		for(int k=0;k<rows;k++){
			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					if(distance[i][k] == INF || distance[k][j] == INF) {
                        continue;
                    }
					if(distance[i][j] > distance[i][k] + distance[k][j]){
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}		
			}
		}

		for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                if(distance[i][j] == INF)
                	distance[i][j] = -1;
            }
        }

		System.out.println("The minimum distance matrix is ");
		for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("The jumps need to be done to go from chair 1 to 3 are ");
		findpath(path,0,2);
	
}

	
	static void findpath(int path[][] , int s,int e){
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.addFirst(e);

		while(true){
			e = path[s][e];
			if(e == -1)
				return;
			stack.addFirst(e);
			if(s == e)
				break;
		}


		//queue.addFirst(s);

		while(!stack.isEmpty()){
			System.out.print(stack.pollFirst() + " ");
		}
		System.out.println();
	}

	static int[][] creatematrix(int chairs, int jump[]){
		int mat[][] = new int[chairs][chairs];

		for(int i=0;i<mat.length;i++){
			int x = (jump[i] + i)%chairs;
			int y = (i-jump[i] + chairs)%chairs;

			mat[i][x] = jump[i];
			mat[i][y] = jump[i];
			for(int j=0;j<chairs;j++){
				if(j!=x && j!= y)
					mat[i][j] = INF;
			}
		}

		/*for(int i=0;i<chairs;i++){
			for(int j=0;j<chairs;j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}*/

		return mat;
	}

	public static void main(String[] args) {
		int chairs = 3;
		int jump[] = {2,3,1};
		int distancematrix[][] = creatematrix(chairs, jump);

		int rows = distancematrix.length;
		int cols = distancematrix[0].length;

		flloydwarshall(distancematrix, rows, cols);
	}
}