package temp;

import java.util.ArrayList;
import java.util.Iterator;

class team {
	private String name;
	private Integer rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	
	
	static String match(team t1,team t2) {
		String answer = new String();
		if(t1.getRank()>t2.getRank()) {
			answer = t1.getName();
		}
		else {
			answer = t2.getName();
		}
		return answer;
		
	}
	
}
public class knock_out_game {
	public static void main(String[] args) {
		int teams = 16;
		ArrayList<team> a1 = new ArrayList<>();
		ArrayList<String> a2 =  new ArrayList<>();
		
		for(int i=0;i<teams;i++) {
			team t = new team();
			t.setName("A" + (i+1));
			t.setRank(i+1);
			a1.add(t);
		}
		
		int i=0;
		System.out.println("Total teams " + teams);
		while(!a1.isEmpty() && teams>1) {
			
			String answer = team.match(a1.get(i),a1.get(i+1));
			System.out.println(" Match between "+a1.get(i).getName() + " " + a1.get(i+1).getName());
			
			if(teams==2)
				System.out.println(" Winner of Tournament is " + answer + "\n");
			else
				System.out.println(" Winner of Match is " + answer + "\n");
			a2.add(answer);
			
			i=i+2;
			if(i==teams) {	
				i=0;
				for(Iterator<team> it = a1.iterator();it.hasNext();) {
					team tt = it.next();
					if(!a2.contains(tt.getName())) {
						it.remove();;
					}
				}
				a2.clear();
				teams=teams/2;
				
				if(teams>1)
					System.out.println(" Total teams " + teams);
			}
		}
		
	}
}
