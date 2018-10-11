import java.util.*;
import java.util.Scanner;

//Assumption that each element is distinct.
class kthsmallest{

	public static void main(String[] args) {

		List<Integer> A = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,12,13));
		//find 5th smallest element
		kthsmallest k = new kthsmallest();
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter number kth smalles elemts ");
		int search  = sc.nextInt();
		int element = k.kthsmallest(A,0,(A.size()-1),search);
		if(element == -1){
			System.out.println("Not exists");
		}
		else{
			System.out.println(" " + element);
		}
	}

	public int kthsmallest(List<Integer> A, int l, int r, int B) {

		if(B>0 && B<=((r-l)+1) ){

			int n =((r-l)+1);
			
			if(n > 5){

				int medianOfmedian =  goodPivot(A,l,r);
				//System.out.println(" aa "  + medianOfmedian + " value " + A.get(medianOfmedian));
				int position = partition(A,l,r,medianOfmedian);
				//System.out.println( " bb " + position);
				//System.out.println( " search for " + (B-1) + " posisition " + position + " l " + l );
				if((position-l) == (B-1)){
					int ans = A.get(position);
					return ans;
				}

				if(position-l > B-1)
					return kthsmallest(A,l,position-1,B);

				return kthsmallest(A,position+1,r,B-(position-l+1));
			}

	    	else{
	    		//sorting last 5 elements
	    		int i=l;
	    		for(int j=i;j<i+n;j++){
    				for(int k=j+1;k<i+n;k++){
    					if(A.get(j)>A.get(k)){
	    					swap(A,j,k);
	    				}
    				}
    			}
	    		return A.get(i+B-1);
	    	}
		}
		else{
			return -1;
		}
		
    }

    public int partition(List<Integer> A, int l, int r, int medianOfmedian){

    	swap(A,r,medianOfmedian);
    	int pivot = A.get(r);
    	//System.out.println( " pivot " + pivot);
    	int i = l;
    	//System.out.println( "before array " + A.toString());
	    for (int j = l; j <= r - 1; j++)
	    {
	        if (A.get(j) <= pivot)
	        {

	            swap(A,i,j);
	            i++;
	            //System.out.println( " i " + i);
	        }
	    }
 		swap(A,i,r);
 		//System.out.println( "after array " + A.toString());
    	return i;
    }

    public int goodPivot(List<Integer> A,int l, int r){
    	int i=l;
    	int count=l;
    	while(i<=r){
    		if((r-i+1)>5){
    			for(int j=i;j<i+5;j++){
    				for(int k=j+1;k<i+5;k++){
	    				if(A.get(j)>A.get(k)){
	    					swap(A,j,k);
	    				}
    				}
    			}
    			swap(A,count,i+2);
    			count++;
    			i=i+5;
    		}
    		else{
    			//sorting last group which has less than 5 elements
    			int n=r-i+1;
    			for(int j=i;j<i+n;j++){
    				for(int k=j+1;k<i+n;k++){
    					if(A.get(j)>A.get(k)){
	    					swap(A,j,k);
	    				}
    				}
    			}
    			swap(A,count,i+(n/2));
    			count++;
    			i=i+n;
    		}
    		
    	}

    	if((count-l)>=5)
    		return goodPivot(A,l,count-l-1);
    	//sorting last remaining pivots
    	for(int j=l;j<count;j++){
    		for(int k=j+1;k<count;k++){
    			if(A.get(j)>A.get(k)){
	    			swap(A,j,k);
	    		}
    		}
    	}
    	//System.out.println( " good pivot  " + A.toString());
    	return (l+((count-l)/2));

    }

    public void swap(List<Integer> A,int j,int k){
    	int temp = A.get(j);
	    A.set(j,A.get(k));
	    A.set(k,temp);
	 }
}