package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	//head;
	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
        this.head = new DoubleLinkedListNode<T>();
        this.last =  (DoubleLinkedListNode<T>) head;
    } 
	
	@Override
	public void insertFirst(T element) {
		
		DoubleLinkedListNode<T> nodeH = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		
		if(element != null) { 
			
			// nil <--> NO <--> nil
			if(this.isEmpty()) {
				this.setHead(nodeH);
				this.setLast(nodeH);  
				
			} else {
				
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(nodeH);
				nodeH.setNext(this.getHead());
				nodeH.setPrevious(new DoubleLinkedListNode<T>());
				this.setHead(nodeH);
			}
			
		} 
	}
	 

	
	public void insert(T element) { // fim
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		
		if(this.isEmpty()) {
			this.setHead(node);
			this.setLast(node);
			 
		} else {
			
			this.getLast().setNext(node);
			node.setPrevious(this.getLast()); 
			node.setNext(new DoubleLinkedListNode<T>());
			this.setLast(node);
		}
	}
	
	
	public void remove(T element) {
		
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
		
		
		for(int i = 0; i < this.size(); i++) {
			if(aux.getData().equals(element)) {
				if(0 == i) {
					this.removeFirst();
					
				} else if(i == this.size() - 1) {
					this.removeLast();
					
				} else {
					while(!aux.isNIL() && !aux.getData().equals(element)) {
						aux = (DoubleLinkedListNode<T>) aux.getNext();
					}
					
					if(!aux.isNIL()) {
						((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
						aux.getPrevious().setNext(aux.getNext());
					}
				}
				
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
		}
		
		
		
		
		
		if(!this.isEmpty()) {
			if(this.getHead().getNext().isNIL() && this.getHead().getData().equals(element)) { 
				this.setHead(new DoubleLinkedListNode<T>());
				this.setLast(new DoubleLinkedListNode<T>());
				
			} else {
				
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				if(!aux.isNIL()) {
					((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.getPrevious());
					aux.getPrevious().setNext(aux.getNext());
				}
				  
			}
		}
	}
	   
	   
	   @Override
	    public T search(T element) {
	        T found = null;
	        if (!this.isEmpty() && element != null) {
	            DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
	            DoubleLinkedListNode<T> auxLast = this.getLast();

	            while (!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && !auxHead.getData().equals(element)
	                    && !auxLast.getData().equals(element)) {
	                auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
	                auxLast = auxLast.getPrevious();
	            }

	            if (auxHead.getData().equals(element)) {
	                found = auxHead.getData();
	            }

	            if (auxLast.getData().equals(element)) {
	                found = auxLast.getData();
	            }
	        }

	        return found;

	    }
	
 
	@Override 
	public void removeFirst() {
		if(!this.isEmpty()) {
			
			if(this.getHead().getNext().isNIL()) {
				this.setHead(new DoubleLinkedListNode<T>());
				this.setLast(new DoubleLinkedListNode<T>());
				 
			} else { 
				this.setHead(this.getHead().getNext());
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
				
			}
		} 
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()) {
			if(this.getHead().getNext().isNIL()) {
				this.setHead(new DoubleLinkedListNode<T>());
				this.setLast(new DoubleLinkedListNode<T>());
				
			} else {
				this.setLast(this.getLast().getPrevious());
				this.getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
	

}
