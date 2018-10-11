import java.*;

/*Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

Examples :

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} */

public class RearrangeArr{
	void rightRotate(int cur,int wrongIndex,int arr[]){
		int temp = arr[cur];
		for(int i=cur;i>wrongIndex;i--){
			arr[i]=arr[i-1];
		}
		arr[wrongIndex] = temp;
	}
	
	void rearrange(int arr[]){
		int length = arr.length;
		int flag=0;
		int wrongIndex=-1;
		for(int i=1;i<length;i++){
			
			if(wrongIndex>0 && wrongIndex<length){
				if( (arr[i]>=0 && arr[wrongIndex]<0) || (arr[i]<0 && arr[wrongIndex]>=0)){
					rightRotate(i,wrongIndex,arr);
					wrongIndex = wrongIndex + 2;
					if((wrongIndex<length) && ((arr[wrongIndex]<0 && arr[wrongIndex-1]>=0) || (arr[wrongIndex]>=0 && arr[wrongIndex-1]<0)) ){
						wrongIndex = -1;
					}
				}
			}

			if(wrongIndex==-1){
				if( (arr[i]<0 && arr[i-1]<0) || (arr[i]>=0 && arr[i-1]>=0) ){
					wrongIndex=i;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, -2, -3, -4, 1, 0};
		
		RearrangeArr ra = new RearrangeArr();
		ra.rearrange(arr);
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		
	}
}