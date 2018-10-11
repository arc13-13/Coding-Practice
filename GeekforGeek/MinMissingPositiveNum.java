import java.*;
// remaining
public class MinMissingPositiveNum{

	int findMinPosNum(int arr[],int n){
		int lowestNum = Math.pow(2,32);
		int ifOneExistsNum = 1;
		for(int i=0;i<n;i++){
			if(arr[i]>0 && arr[i]<lowestNum)
				lowestNum = arr[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = {-6,-5,-3,1,4,5,8};
		MinMissingPositiveNum mp = new MinMissingPositiveNum();
		mp.findMinPosNum(arr);
	}
}