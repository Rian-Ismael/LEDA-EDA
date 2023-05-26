package problems;

public class Main {

	public static void main(String[] args) {
		
		SingleLinkedListImpl<Integer> list = new SingleLinkedListImpl<Integer>();
		SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<Integer>();
		

		node1.setData(2);
		node1.setNext(new SingleLinkedListNode<Integer>());
		node1.getNext().setData(3);
		node1.getNext().setNext(new SingleLinkedListNode<Integer>());
		node1.getNext().getNext().setData(4);
		node1.getNext().getNext().setNext(new SingleLinkedListNode<Integer>());
		node1.getNext().getNext().getNext().setData(5);
		node1.getNext().getNext().getNext().setNext(new SingleLinkedListNode<Integer>());
		 
		SingleLinkedListNode<Integer> no = list.rotate(node1, 2);
	    
		
		
		
		while(!no.isNIL()) {
			System.out.println(no.getData());
			no = no.getNext();
		}
		

		
		
	}
}
