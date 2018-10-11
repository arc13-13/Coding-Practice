import java.util.*;

class factors{

	HashMap<Integer,Integer> countPimeFact(ArrayList<Integer> al){
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(Integer facti : al){
			if(hmap.containsKey(facti)){
				//increase count if number already present
				hmap.put(facti,hmap.get(facti) + 1);
			}
			else{
				//add the number if it is not present in map
				hmap.put(facti,1);
			}
		}
		//System.out.println(hmap);
		return hmap;
	}

	HashMap<Integer,Integer> getPrimeFactors(int num){	
		int i=2;	
		ArrayList<Integer> al = new ArrayList<Integer>();
		//we could also use modified sieve of erathonesis theorem but then
		//array size would be of 10^8 in worst case which is not possible
		while(i*i<=num){
			if(num % i == 0)
			{
				num = num / i;
				al.add(i);
			}
			else
			{		
				i++;
			}
		}
		if(num>1)
			al.add(num);

		return (countPimeFact(al));

	}

	int unionOfPrimeFactorsOfTwoNumbers(final ArrayList<HashMap<Integer,Integer>> list,int i,int j){
		//we need to create new two object of hashmap as
		//arrayList are pass by reference and thus original 
		//hashmaps were getting changed
		HashMap<Integer,Integer> m1 = new HashMap<Integer,Integer>(list.get(i)); 
		HashMap<Integer,Integer> m2 = new HashMap<Integer,Integer>(list.get(j)); 
		//System.out.println("m1 = " + m1 + " and m2 = " + m2);
		for(Integer num : m1.keySet()){
			if(m2.containsKey(num)){
				//add count of m1 and m2 if number already present
				m2.put(num, m2.get(num) + m1.get(num));
				
			}
			else{
				//add the number if it is not present in map m2
				m2.put(num,m1.get(num));
				
			}
		}
		//System.out.println(m2 + " -- ");
		int product=1;
		for(Integer num : m2.keySet()){
			product = product * (m2.get(num) + 1);
		}
		m1.clear();
		m2.clear();
		return product;
	}

	int maxFactor(int arr[],int length){
		//this is not working 
		// ArrayList<HashMap> list_of_prime_fators_of_individual = new ArrayList<HashMap>(length);
		final ArrayList<HashMap<Integer,Integer>> list_of_prime_fators_of_individual = new ArrayList<HashMap<Integer,Integer>>(length);
		for(int i=0;i<length;i++){
			list_of_prime_fators_of_individual.add(getPrimeFactors(arr[i]));
		}

		//System.out.println(list_of_prime_fators_of_individual + "  ");

		int max=-1;
		int temp;
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				//System.out.println(list_of_prime_fators_of_individual.get(i) + " " + list_of_prime_fators_of_individual.get(j));
				temp = unionOfPrimeFactorsOfTwoNumbers(list_of_prime_fators_of_individual,i,j);
				if(temp>max)
					max = temp;
			}
		}
		return max;
	}

	public static void main(String[] args){

	 	int arr[] = {4,3,8};
	 	factors f = new factors();
	 	System.out.println(f.maxFactor(arr,arr.length));
	 }
}