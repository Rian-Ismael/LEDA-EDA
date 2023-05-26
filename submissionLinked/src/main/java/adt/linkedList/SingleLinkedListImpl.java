package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}
 
	@Override 
	public int size() { 
		int size = 0;
		
		if(!this.isEmpty()) {
			SingleLinkedListNode<T> aux = this.getHead();
			
			while(!aux.isNIL()) { 
				aux = aux.getNext();
				size++; 
			}   
		} 
		
		return size;
	}  

	@Override 
	public T search(T element) { 
		SingleLinkedListNode<T> aux = this.getHead();
		
		if(element != null && !this.isEmpty()) {
			while(!aux.isNIL()) {
				if(aux.getData().equals(element)) {
					return aux.getData();

				} else {
					aux = aux.getNext();
				}
			}
		}
		
		return null;
	} 

	@Override
	public void insert(T element) { // fim insertLast
		
		SingleLinkedListNode<T> aux = this.getHead();
		
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		
		
		if(this.isEmpty() && element != null) {
			this.setHead(node);
				 
		} else if(element != null) {
			
			// A B C X
			
			while(!aux.getNext().isNIL()) {
				aux = aux.getNext();		
			}
			//-->
			
			aux.setNext(node);
			node.setNext(new SingleLinkedListNode<T>());	
			
		}
	}

	@Override
	public void remove(T element) { // qualquer lugar
		SingleLinkedListNode<T> aux = this.getHead();
		
		if(element != null) {
			
			if(!this.isEmpty()) {
				 
						
				// A B C X
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					aux = aux.getNext(); 
				}
				
				
				
				if(!aux.isNIL()) {
					aux.setData(aux.getNext().getData());
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] retorno =  (T[]) new Comparable[this.size()];
		
		SingleLinkedListNode<T> aux = this.getHead();
		
		int i = 0;
		while(!aux.isNIL()) {
			retorno[i] = aux.getData();
			i++;
			aux = aux.getNext();
		}
		
		return retorno;
			
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
