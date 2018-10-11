import java.util.*;

//EXAMPLE
//Input: Tact Coa
//Output: True (permutations: "taco cat". "atco cta". etc.)

//here a normal approach is to take hashmap and check atmost only one key can have
//odd value count.

//but we will use bitvector to reduce space complexity
class PalindromePermutation{

	boolean isPalindromePermutation(String s){
		int bitvector=0;
		int ascii_diff=0;
		int temp;

		for(int i=0;i<s.length();i++){
			temp = s.charAt(i);
			if(temp != ' '){

				//handling capital letters
				if(temp>='A' && temp<='Z'){
					temp = temp + 32;
				}

				ascii_diff = temp - 'a';

				if( (bitvector & (1<<ascii_diff)) > 0 ){
					//when char is already present, we need to make that bit again back to zero
					//OR with complement of number
					//~000100 = 111011;
					bitvector = bitvector & ~(1<<ascii_diff);
				}
				else{
					bitvector = bitvector | (1<<ascii_diff);
				}
				
			}
			//System.out.println(bitvector);
		}

		//now we need to check that there could be only one '1' present in bitVector for
		//odd palindrom or either no '1' should be there for even palindrome
		if(bitvector==0){
			return true;
		}
		else if( (bitvector & (bitvector-1)) == 0){
			//now bitvector should have only single '1' to get palindrome
			//eg: bitvector : 1000 and bitvector-1 : 0111
			//so when you 'and' them, you get zero.
			//This will happen only when number is in power of 2(that is number
			//has only single bit in its binary representation). 
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		PalindromePermutation pp  = new PalindromePermutation();

		String s = "abc def fed caba";
		System.out.println(pp.isPalindromePermutation(s));
	}
}