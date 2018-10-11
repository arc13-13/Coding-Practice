import java.util.*;
import java.io.*;

class FindRepeatedWordsInFile{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("FindRepeatedWordsInFile.txt"));
		String currentLine = br.readLine();
		//System.out.println(currentLine);
		Map<String,Integer> hmap = new HashMap<String,Integer>();

		while(currentLine!=null){
			//System.out.println(currentLine);		
			String words[] = currentLine.split(" ");
			
			for(String word : words){

				if(hmap.containsKey(word)){
					//increasing count
					hmap.put(word, hmap.get(word) + 1);
				}
				else{
					//first occurence of word
					hmap.put(word,1);
				}
			
			}
			//go to next line
			currentLine = br.readLine();
		}

		//creating arraylist of entryList
		List<Map.Entry<String,Integer>> entrySetList = new ArrayList<Map.Entry<String,Integer>>(hmap.entrySet());

		//now we will sort entryList based on its value as we want word with highest
		//count as first output
		Collections.sort(entrySetList, new Comparator<Map.Entry<String,Integer>>(){
			@Override
			public int compare(Map.Entry<String,Integer> m1, Map.Entry<String,Integer> m2){
				return ((m2.getValue()).compareTo(m1.getValue()));
			}
		});

		for(Map.Entry<String,Integer> entry : entrySetList){
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}

	}
}
