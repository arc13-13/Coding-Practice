import java.util.*;

class MyLinkedList{

	//we use static class so that we don't need reference to an object to use this 
	//class, we can use parentClass.childClass ch = new parentClass.childClass();
	static class Node {
		int data;
		Node next; 
		Node(int data){
			//this is used so that compiler understands, that on left side we want class 
			//variable and not local variable
			this.data = data; 
			next = null;
		}
	}

	//printing Linked List
	static void printLinkedList(Node head){
		Node current = head;
		while(current!=null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	//clearing cmd console to get clear view
	static void clearConsoleScreen(){
		System.out.print("\033[H\033[J");
	}

	//create a linked list
	static Node createLinkedList(){
		clearConsoleScreen();
		System.out.println("Number of Elements you want to insert in LinkedList : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter data for " + n + " Node");
		
		Node head = new Node(sc.nextInt());
		n--;

		Node current=head;
		Node temp;
		while(n>0){
			temp = new Node(sc.nextInt());
			current.next=temp;
			current=temp;
			n--;
		}
		return head;
		//printLinkedList(head);
	}

	public static void main(String[] args) {
		
		MyLinkedList ml = new MyLinkedList();
		//clearing console screen
		ml.clearConsoleScreen();
		//ml.createLinkedList();
	}
}