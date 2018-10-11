import java.util.*;

//TC : O(n)
//SC : O(1)

class FindLoopInLinkedList extends MyLinkedList{

	void isLoopinLinkedList(MyLinkedList.Node head){
		//we will take two pointer, one will move slowly and one will move faster
		//if there will be loop they will definitely meet at some point.
		//but if there will be no loop then faster pointer should discover null
		MyLinkedList.Node tortoise = head;
		MyLinkedList.Node rabbit = head;
		int flag=1;
		while(rabbit!=null){
			rabbit = rabbit.next.next;
			tortoise = tortoise.next;
			if(rabbit==tortoise){
				flag=0;
				System.out.println(" Loop exists in Linked List ");	
				break;
			}
		}
		if(flag==1)
			System.out.println(" No loop exists in Linked List ");
	}

	public static void main(String[] args) {
		
		MyLinkedList.Node head = new MyLinkedList.Node(5);
		head.next = new MyLinkedList.Node(8);
		head.next.next = new MyLinkedList.Node(6);
		head.next.next.next = new MyLinkedList.Node(9);
		head.next.next.next.next = new MyLinkedList.Node(10);
		head.next.next.next.next.next = new MyLinkedList.Node(15);
		head.next.next.next.next.next.next = new MyLinkedList.Node(17);
		head.next.next.next.next.next.next.next = new MyLinkedList.Node(20);	

		FindLoopInLinkedList fl = new FindLoopInLinkedList();
		MyLinkedList.clearConsoleScreen();

		System.out.println(" Before Loop ");
		fl.isLoopinLinkedList(head);

		//creating loop
		//setting 20's next --> 6
		head.next.next.next.next.next.next.next.next = head.next.next;
		System.out.println(" After Looping ");
		fl.isLoopinLinkedList(head);
	}
}