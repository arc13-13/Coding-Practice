public class Solution {
    
    public int min(int a,int b, int c){
        if(a<b && a<c)
            return a;
        else if(b<a && b<c)
            return b;
        else 
            return c;
    }
    
    public int coverPoints(int[] A, int[] B) {

        int count=0;
        for(int i=1;i<A.length;i++){
            int a=Math.abs(A[i]-A[i-1]);
            int b=Math.abs(B[i]-B[i-1]);
            if(a<b)
                count+=b;
            else
                count+=a;
        }
        return count;
    }
}
