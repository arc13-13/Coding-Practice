public class Trie {

	static final int alphabet_size=26;

	static class TrieNode{
		TrieNode[] children = new TrieNode[alphabet_size];

		boolean isEndOfWord;

		TrieNode(){
			isEndOfWord = false;
			for(int i=0;i<alphabet_size;i++){
				children[i] = null;
			}
		}
	}

	static TrieNode root;

	public static void delete(String key){
		delete1(root,key,0);

	}

	private static boolean delete1(TrieNode current,String word,int index){
		if(index == word.length()){
			if(!current.isEndOfWord)
				return false;
			current.isEndOfWord = false;

			return  current.children.length == 0;
		}
		int i=word.charAt(index) - 'a';
		TrieNode node =  current.children[i];
		if(node == null){
			return false;
		}
		boolean shouldDeleteCurrentNode = delete1(node,word,index+1);

		if(shouldDeleteCurrentNode){
			current.children[i]=null;

			return current.children.length == 0;
		}
		return false;
	}

	static void insert(String key){
		int index;
		TrieNode pCrawl = root;
		for(int i=0;i<key.length();i++){
			index = key.charAt(i) - 'a';
			if(pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
			pCrawl = pCrawl.children[index];
		}

		pCrawl.isEndOfWord = true;
	} 

	static boolean search(String key){
		int index;
		TrieNode pCrawl = root;
		for(int i=0;i<key.length();i++){
			index = key.charAt(i) - 'a';
			if(pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	public static void main(String arg[]){
		String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their"};
      
        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();
        for(int i=0;i<keys.length;i++){
        	insert(keys[i]);
        }

        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        delete("the");

        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("there") == true)
            System.out.println("there --- " + output[1]);
        else System.out.println("there --- " + output[0]);
	}
}