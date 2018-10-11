public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findHammingDist(String a,String b){
        int count=0;
        int lengthA = a.length();
        int lengthB = b.length();
        if(lengthA>lengthB){
            for(int i=0;i<lengthA;i++){
                if( (i+1)>lengthB ){
                    if( a.charAt(i)=='1')
                        count++;
                }
                else if(a.charAt(i) != b.charAt(i)){
                    count++;
                }
            }    
        }
        else{
            for(int i=0;i<lengthB;i++){
                if( (i+1)>lengthA ){
                    if( b.charAt(i)=='1')
                        count++;
                }
                else if(b.charAt(i) != a.charAt(i)){
                    count++;
                }
            }  
        }
        return count;
    }
    
    public int hammingDistance(final List<Integer> A) {
        ArrayList<String> arr = new ArrayList<String>(); 
        for(int i=0;i<A.size();i++){
            int num = A.get(i);
            StringBuilder temp = new StringBuilder();
            while(num>0){
                int no = num % 2;
                temp.append(String.valueOf(no));
                num = num / 2;
            }
            arr.add(temp.toString());
        }
       //System.out.println(arr.toString());
        int count=0;
        int var1=0;
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                var1 = findHammingDist(arr.get(i),arr.get(j)) % 1000000007;
                count = (count + var1)%1000000007;
                count = (count + var1)%1000000007;
            }
        }
        return count;
    }
}
