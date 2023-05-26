package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() { 

	}


	@Override 
	public boolean isEmpty() { 
		return this.getData() == null;
	}

	@Override  
	public int size() {
		int size = 0;
		while(!this.isEmpty()) {
			return 1 + this.getNext().size();
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if(!this.isEmpty() && element != null) {
			
			if(this.getData().equals(element)) {
				result = this.getData();
			} else {
				result = this.getNext().search(element);
			}
		}
		
		return result;
	}

	// LINKED --> LINKED --> LINKED --> linked --> nil

	
	@Override
	public void insert(T element) { // fim
		
		if(element != null) {
			if(this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
				
			} else { 
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) { 
		if(element != null) {
			
			// A B C X
			if(!this.isEmpty()) {
				if(this.getData().equals(element)) {
					setData(this.getNext().getData());
					setNext(this.getNext().getNext());
					
				} else {
					this.getNext().remove(element);
				}
			}
		}
	} 
	
	// SINGLE NORMAL E RECURSIVO (REMOVE) --> CHEGA NO VALOR E REMOVE.
	// SINGLE NORMAL (ADD): CHEGA UM ANTERIOR E ADICIONA O NEXT PRO NODE NOVO.
	// SINGLE RECURSIVO (ADD): CHEGA NO NÓ (NIL) E ADICIONA SETDATA PARA O VALOR.

	@Override
	public T[] toArray() {
		T[] retorno = (T[]) new Comparable[this.size()];
		                                   
		toArray(retorno, 0);
		
		return retorno;
	}

	private void toArray(T[] retorno, int i) {
		if(!this.isEmpty()) {
			retorno[i] = this.getData();
			this.getNext().toArray(retorno, i+1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
