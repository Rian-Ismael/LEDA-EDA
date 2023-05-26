package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	// LINKED --> LINKED --> LINKED
	@Override 
	public void insertFirst(T element) {
		
		if(this.isEmpty()) { 
			this.insert(element); 
			 
			    
		} else { 
			 
			RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<T>();
			node.setData(this.data);
			 
			this.setData(element); 
			node.setNext(this.next);this.isEmpty();
			((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(node);
			node.setPrevious(this);
			this.setNext(node);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
		}
	}
	
	public void insert(T element) {
		
		
		if(this.isEmpty()) {
			
			RecursiveDoubleLinkedListImpl<T> nilL = new RecursiveDoubleLinkedListImpl<T>();
			
			this.setData(element);
			
			this.setNext(nilL);
			nilL.setPrevious(this);
			
			if(this.getPrevious() == null) {
				RecursiveDoubleLinkedListImpl<T> nilH = new RecursiveDoubleLinkedListImpl<T>();
				
				this.setPrevious(nilH);
				nilH.setNext(this);
			}
			
		} else {
			this.getNext().insert(element);
		}
	}
	 
	

	@Override
	public void removeFirst() {
		if(!this.isEmpty()) {
			if(this.getPrevious().isEmpty() && this.getNext().isEmpty()) {
				 
				this.setPrevious(null);
				this.setData(null);
				 
				this.setNext(null);
				
				
			} else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		} 
	}

	@Override
	public void removeLast() {
		
		if(!this.isEmpty()) {
			if(this.getNext().isEmpty()) { 
				this.setData(null);
				this.setNext(null);
				 
				if(this.getPrevious().isEmpty()) {
					this.setPrevious(null);
				}
				
			} else { 
				((DoubleLinkedList<T>) this.getNext()).removeLast();
			}
		}
		
	}
	
	public void remove(T element) {
		if(!this.isEmpty() && element != null) {
			if(this.getData().equals(element)) {
				if(this.getPrevious().isEmpty()) {
					this.removeFirst();
					
				} else if(this.getNext().isEmpty()) {
					this.removeLast();
					
				} else {
					this.getPrevious().setNext(this.getNext());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this.getPrevious());
				}
			} else {
				this.getNext().remove(element);
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
