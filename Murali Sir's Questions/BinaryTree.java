import java.util.*;
import java.lang.*;

class Node{
	int key;
	Node left,right;
	public Node(int item){
		key = item;
		left=right=null;
	}
}

class BinaryTree{

	Node root;

	public BinaryTree(){
		root = null;
	}

	void recursivePostOrder(Node node)
	{
		if(node == null)
			return;

		recursivePostOrder(node.left);
		recursivePostOrder(node.right);
		System.out.print(node.key + " ");

	}

	void recursivePreOrder(Node node){
		
		if(node == null)
			return;

		System.out.print(node.key + " ");
		recursivePreOrder(node.left);
		recursivePreOrder(node.right);
	}

	void recursiveInOrder(Node node){
		
		if(node == null)
			return;

		recursiveInOrder(node.left);
		System.out.print(node.key + " ");
		recursiveInOrder(node.right);
	}

	void iterativePostOrder(Node node){
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		Stack<Node> s1 = new Stack<Node>();

		while(!s.isEmpty()){
			Node n = s.pop();
			if(n.left != null)
				s.push(n.left);
			if(n.right != null)
				s.push(n.right);
			s1.push(n);
		}
		while(!s1.isEmpty()){
			System.out.print(s1.pop().key + " ");
		}
	}

	void recursivePostOrder()  {  recursivePostOrder(root);  }
   	void recursiveInOrder()    {  recursiveInOrder(root);   }
    void recursivePreOrder()   {  recursivePreOrder(root);  }

    void iterativePostOrder()  {  iterativePostOrder(root);  }
   /*	void iterativeInOrder()    {  iterativeInOrder(root);   }
    void iterativePreOrder()   {  iterativePreOrder(root);  }*/

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);

		System.out.println("Post Order in recursive way");
		tree.recursivePostOrder();
		System.out.println("Pre Order in recursive way");
		tree.recursivePreOrder();
		System.out.println("In Order in recursive way");
		tree.recursiveInOrder();

		System.out.println("Post Order in iterative way");
		tree.iterativePostOrder();

	}
}