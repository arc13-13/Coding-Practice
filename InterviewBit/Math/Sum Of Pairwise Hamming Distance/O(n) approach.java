public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
  
    public int hammingDistance(final List<Integer> A) {
        int ans = 0; // Initialize result
 
        // traverse over all bits
        for (int i = 0; i < 32; i++) {
             
            // count number of elements 
            // with i'th bit set
            int count = 0;
            //taking each number and anding it with 1 at different position.
            //at first 1<<0 ( it means shift 1 by 0 digit) so last digit(binary digit of a integer) is AND with 1.
            //then 1<<1 means number is ANDED with 10. So we will come to know what is there at 2nd place.
            for (int j = 0; j < A.size(); j++)
                if ((A.get(j) & (1 << i)) == 0)
                    count++;
 
            // Add "count * (n - count) * 2" 
            // to the answer
            // count will contain the number for which there where all O's and (N- count) will contain where it was all 1's
            // possible pair between two group is to multiply them. Count*(N-Count)
            // as each comparision has to donate two answer --> for eg. comparing 2,4 will have same ans as 4,2.
            // therefore ans += count*(N-Count)*2;
         
            ans =( ans + (count * (A.size() - count) * 2) ) % 1000000007;
        }
         
        return ans;
    }
}
