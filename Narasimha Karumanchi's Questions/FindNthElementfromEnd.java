import java.util.*;

class FindNthElementfromEnd extends MyLinkedList{
	
	void mainLogic(MyLinkedList.Node head, int num){
		MyLinkedList.Node current = head;
		
		while(num>0){
			current = current.next;
			num--;
		}
		//at this point current is pointing to num'th node
		//take another pointer from start and now move forward both pointer
		//when current will point to last position, 2nd pointer will point to
		//num'th element from last
		MyLinkedList.Node back = head;
		while(current!=null){
			current = current.next;
			back = back.next;
		}
		System.out.println("Nth element from last is "+back.data);
	}

	public static void main(String[] args) {
		
		MyLinkedList.Node head = MyLinkedList.createLinkedList();
		FindNthElementfromEnd fe = new FindNthElementfromEnd();
		System.out.println("Enter Nth number from Last which you want to find");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		fe.mainLogic(head,num);

		//MyLinkedList.printLinkedList(head);
	}
}