import java.util.*;

//read question from 
//https://www.geeksforgeeks.org/validity-of-a-given-tic-tac-toe-board-configuration/

class TicTacToeValidation{

	boolean wins(int arr[], char c){
		//all possibilites of 3 boxes where c can win
		//for eg: c can win at position 012 or 345 or 246, etc.
		String s = "012345678036147258048246";

		int e1,e2,e3;
		for(int i=0;i<=(s.length()-3);i=i+3){
			e1 = arr[Integer.parseInt(String.valueOf(s.charAt(i)))];
			e2 = arr[Integer.parseInt(String.valueOf(s.charAt(i+1)))];
			e3 = arr[Integer.parseInt(String.valueOf(s.charAt(i+2)))];
			if(e1==c && e2==c && e3==c){
				return true;
			}
		}
		return false;
	}

	//Trick is to find all wrong condition and return Invalid for it.
	String isValid(int arr[]){
		int countX=0;
		int countO=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]=='X')
				countX++;
			else if(arr[i]=='O')
				countO++;
		}

		System.out.println("X : " + countX + " O : " + countO);
		//as always X starts first,no. of X will should always be greater than
		//or equal to O in any valid state. 
		if(countO>countX){
			System.out.println("1");
			return "Invalid";
		}

		if(countX==countO || countX==countO+1){
			//check if X wins
			if(wins(arr,'X')){

				//then O should not win
				if(wins(arr,'O')){
					System.out.println("2");
					return "Invalid";
				}

				//X can win only when Xcount=Ocount+1
				if(countX==countO+1){
					System.out.println("3");
					return "Valid";
				}
			}

			if(wins(arr,'O')){

				//we already checked condition where both wins, so no need to check again

				//O can win only when countX and countO are equal
				if(countO==countX){
					System.out.println("4");
					return "Valid";
				}
			}

			//neither X wins nor O wins but countX=count0 or countX=countO+1. Therefore valid
			return "Valid";
		}
		System.out.println("5");
		return "Invalid";

	}

	public static void main(String[] args) {
		int arr[]={'X','X','O'
				  ,'O','O','X'
				  ,'X','O','X'};
		
		int arr1[]={'X','O','O'
				  ,'O','O','X'
				  ,'X','O','X'};
		
		int arr2[]={'X','X','X'
				  ,'O','O','X'
				  ,'X','O','X'};

		int arr3[]={'X','X','O'
				  ,'O','O','X'
				  ,'X','O','X'};

		TicTacToeValidation t = new TicTacToeValidation();
		System.out.println("board is " + t.isValid(arr));	
		System.out.println("board is " + t.isValid(arr1));	
		System.out.println("board is " + t.isValid(arr2));
		System.out.println("board is " + t.isValid(arr3));
	}
}