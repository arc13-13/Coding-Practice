import java.util.*;
import java.io.*;

class Find10MaxPayers {

	

	static class person{
		String name;
		int tax;
		person(String name,int tax){
			this.name = name;
			this.tax = tax;
		}
	}

	void swap(person arr[],int a,int b){
		person temp= arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	int findRank(person arr[],int rank,int left,int right){
		//we will take last element as pivot
		//random partition funtion
		Random random = new Random();
		int randIndex = left + random.nextInt(right-left+1);
		//swap
		swap(arr,randIndex,right);

		int i = left-1;
		for(int j=left;j<right;j++){
			if(arr[j].tax <= arr[right].tax){
				i++;
				swap(arr,i,j);
			}
		}
		i++;
		swap(arr,i,right);

		if(i-left==rank-1)
			return i;
		else if(i-left<rank-1){
			findRank(arr,rank-(i-left+1),i+1,right);
		}
		else{
			findRank(arr,rank,left,i-1);
		}
		return 0;
	}

	int readFunction(BufferedReader br,person arr[],int start,int count) throws Exception {

		String current;
		int index=start;
		
		while( count>0){
			if( (current = br.readLine()) != null){
				String word[] = current.split(" ");
				person p = new person(word[0].trim(),Integer.valueOf(word[1].trim()));
				arr[index]=p;
				index++;
				count--;
			}
			else{
				return count;
			}	
		}
		return count;
	}

	public static void main(String[] args) throws Exception  {
		int count=20;
		int largest=10;
		//largest numbers nikal ne he
		//okat count jitne ki he at a time

		person arr[] = new person[count];
		Find10MaxPayers fp = new Find10MaxPayers();
		BufferedReader br = new BufferedReader(new FileReader("Find10MaxPayers.txt"));

		fp.readFunction(br,arr,0,count);
		
		
		//ystem.out.println(arr[0].name);

		//to get 5th largest, pass 10-5+1 = 6 in findrank
		//which will give 6th smallest value
		int index = fp.findRank(arr,count-largest+1,0,count-1);

		//index will always be 5, as we are finding 6th smallest in array of 10

		for(int i=0;i<largest;i++){
			arr[i] = arr[i+largest];
			arr[i+largest]=null;
		}


		int num;
		while((num = fp.readFunction(br,arr,largest,count-largest))==0){
			index = fp.findRank(arr,count-largest+1,0,count-1);
			//index will always be 5, as we are finding 6th smallest in array of 10
			for(int i=0;i<largest;i++){
				arr[i] = arr[i+largest];
				arr[i+largest]=null;
			}
		}
		
		index = fp.findRank(arr,count-num-largest+1,0,(count-num-1));
		for(int i=0;i<largest;i++){
			arr[i] = arr[i+(count-num-1)-largest+1];
			arr[i+(count-num-1)-largest+1]=null;
		}
		
		System.out.println(arr[0].name + " " + arr[0].tax);
		System.out.println(arr[1].name + " " + arr[1].tax);
		System.out.println(arr[2].name + " " + arr[2].tax);
		System.out.println(arr[3].name + " " + arr[3].tax);
		System.out.println(arr[4].name + " " + arr[4].tax);
		System.out.println(arr[5].name + " " + arr[5].tax);
		System.out.println(arr[6].name + " " + arr[6].tax);
		System.out.println(arr[7].name + " " + arr[7].tax);
		System.out.println(arr[8].name + " " + arr[8].tax);
		System.out.println(arr[9].name + " " + arr[9].tax);

	}
}