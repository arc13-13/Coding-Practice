import java.util.*;

class LongestSubstring{
	//
	int findLongestSubString(String s){
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		//(int)'a' - 97 = 0

		//intialise map
		for(int i=0;i<26;i++){
	        hmap.put(i,-1);
	    }

	    int max=1;
	    int start=0;
	    int countLength=0;
	    int temp;

	    for(int i=0;i<s.length();i++){
	    	temp = (int) s.charAt(i) - 97;
	    	
	    	if(hmap.get(temp) == -1 || hmap.get(temp)<start){
	    		hmap.put(temp,i);
	    		countLength++;
	    	}
	    	else{
	    		if(countLength>max)
	    			max=countLength;

	    		//here we are updating start so that when we go further
	    		//for eg:
	    		//after arc in String
	    		//when A comes we update start
	    		//now when R comes hmap.get(R) will give 1 < start=3 and thus increases count
	    		//which shows that this R which came right now is new one as previous r is less than start
	    		//and thus we need to count it
	    		//and then new values of R in map becomes 4.
	    		start=i;
	    		countLength=0;

	    		hmap.put(temp,i);
	    		countLength++;
	    	} 
	    }

	    if(countLength>max)
	    	max=countLength;

	    return max;

	}

	public static void main(String[] args) {
		
		String s = "arcARCHITA";

		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.findLongestSubString(s.toLowerCase()));

	}


}
