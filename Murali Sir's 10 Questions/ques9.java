class ques9{
	static int editdistanceDp(StringBuilder s1, StringBuilder s2, int insertCost, int deleteCost, int replaceCost){
		int n1 = s1.length();
		int n2 = s2.length();

		int mat[][] = new int[n1+1][n2+1];

		for(int i=0;i<=n1;i++){
			for(int j=0;j<=n2;j++){
				if(i==0)
					mat[i][j] = j*insertCost;
				else if(j==0)
					mat[i][j] = i*deleteCost;
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1];
				}
				else{
					mat[i][j] = Math.min(mat[i-1][j] + deleteCost , Math.min(mat[i][j-1] + insertCost, mat[i-1][j-1] + replaceCost));
				}
			}
		}

		for(int i=0;i<=n1;i++){
			for(int j=0;j<=n2;j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		return mat[n1][n2];
	}

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("abcbbc");
		int insertCost = 2;
		int deleteCost = 3;
		int replaceCost = 4;

		int n = s.length();

		StringBuilder s1 = new StringBuilder(s.substring(0,n/2));
		StringBuilder temp = new StringBuilder(s.substring(n/2,n));

		StringBuilder s2 = new StringBuilder(temp);
		s2.reverse();

		//System.out.println(s2);
		int x = editdistanceDp(s1, s2, insertCost, deleteCost, replaceCost);
		int y = editdistanceDp(s2, s1, insertCost, deleteCost, replaceCost);

/*		System.out.println("x " +x);
		System.out.println("y " + y);
*/
		int result = Math.min(x,y);

		System.out.println("The min cost is " + result);
	}
}