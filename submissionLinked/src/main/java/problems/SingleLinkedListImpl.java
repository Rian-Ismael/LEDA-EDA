package problems;

import java.util.Iterator;

import adt.linkedList.LinkedList;

public class SingleLinkedListImpl<T extends Comparable<T>> implements LinkedList<T> {
 
	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}
	
	
	public void addRecursive(int index, T value) {
		if(index == 0) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(value, new SingleLinkedListNode<T>());
			newNode.setNext(this.getHead());
			this.setHead(newNode);
			
		} else {
			addRecursion(index, value, this.getHead());
		}
	}
	
	private void addRecursion(int index, T value, SingleLinkedListNode<T> node) {
		if(index == 1) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(value, new SingleLinkedListNode<T>());
			newNode.setNext(node.getNext());
			node.setNext(newNode);
			
		}
		
		else {
			addRecursion(index - 1, value, node.getNext());
		}
	}		



	public void removeDuplicatesVoid1() { 
	
		SingleLinkedListNode<T> aux = this.getHead();
		
		while(!aux.isNIL()) {
			if(aux.getData().equals(aux.getNext().getData())) {
				if(!aux.getNext().getNext().isNIL()) {
					aux.setNext(aux.getNext().getNext());
					
				} else {
					aux.setNext(new SingleLinkedListNode<T>());
				}
			}
			aux = aux.getNext();
		}

	}
	
	
	
	public void removeDuplicatesVoid() { 
		
		SingleLinkedListNode<T> aux = this.getHead();
		
		while(!aux.getNext().isNIL()) {
			if(aux.getData().equals(aux.getNext().getData())) {
				
					aux.setNext(aux.getNext().getNext());
					
				} else {
					aux = aux.getNext();
				}
			}
		}
	
	
	
	
	public boolean hasCycle(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> faster = node;
		SingleLinkedListNode<T> slow = node;
		
		while(!faster.isNIL() && !faster.getNext().isNIL()) {
			faster = faster.getNext().getNext();
			slow = slow.getNext();
			
			if(slow == faster) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public int cycleLength(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> faster = node;
		SingleLinkedListNode<T> slow = node;
	
		
		while(!faster.isNIL() && !faster.getNext().isNIL()) {
			faster = faster.getNext().getNext();
			slow = slow.getNext();
			
			
			if(slow == faster) {
				
				SingleLinkedListNode<T> temp = slow;
				int length = 0;
				
				do {
					temp = temp.getNext();
					length++;
					
				} while (temp != slow);
					
				return length;
				
				
				
			}
		}
		
		return 0;
		
	}
	
	
	public void removeCycle(Node head) {
	     Node slow = head;
	     Node fast = head;
	     while (fast != null && fast.next != null) {
	         slow = slow.next;
	         fast = fast.next.next;
	         if (slow == fast) {
	             slow = head;
	//when both slow and fast point to the same node break the loop
	             while (slow.next != fast.next) {
	                 slow = slow.next;
	                 fast = fast.next;
	             }
	// point fast to null, to remove the cycle
	             fast.next = null;
	         }
	     }
	}
	
	
	public SingleLinkedListNode<T> detectCycle(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> faster = node;
		SingleLinkedListNode<T> slow = node;
		
		while(!faster.isNIL() && !faster.getNext().isNIL()) {
			slow = slow.getNext();
			faster = faster.getNext().getNext();
			
			
			if(slow == faster) {
				slow = node;
				
				
				while (slow != faster) {
					
					faster = faster.getNext();
					slow = slow.getNext();
				}
				
				return slow;
			}
			
		}
		
		return null;
	}
	
	
	
	public boolean Happy(int n) {
		int slow = n;
		int faster = n;
		
		
		do {
			slow = findSquare(slow);
			faster = findSquare(findSquare(faster));
			
		} while(slow != faster);
	
		if(slow == 1) {
			return true;
		}
		
		return false;
	}
	
	
	
	private int findSquare(int n) {
		int ans = 0;
		
		while(n > 0) {
			int aux = n % 10;
			
			ans += aux * aux;
			
			n /= 10;
		}
		
		return ans;
	}
	
	
	
	
	public SingleLinkedListNode<T> middle(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> slow = node;
		SingleLinkedListNode<T> faster = node;
		
		
		while(!faster.isNIL() && !faster.getNext().isNIL()) {
			slow = slow.getNext();
			
			faster = faster.getNext().getNext();
		}
		
		return slow;
	}
	
	
	
    public SingleLinkedListNode<T> mergeRecursive(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {
        if (node1 == null) {
            return node2;
        }
        else if (node1.data == null) {
            return node2;
        } 
        if (node2 == null) {
            return node1;
        }
        else if (node2.data == null) {
            return node1;
        }

        if (node1.getData().compareTo(node2.getData()) <= 0) {
            node1.setNext(mergeRecursive(node1.getNext(), node2));
            return node1;
            
        } else {
            node2.setNext(mergeRecursive(node1, node2.getNext()));
            return node2;
        }
    }  

	
	
	public SingleLinkedListNode<T> mergeSort(SingleLinkedListNode<T> node) {
		   if (node == null || node.getNext() == null) {
		        return node;
		    }

	    SingleLinkedListNode<T> temp = node;
	    SingleLinkedListNode<T> slow = node;
	    SingleLinkedListNode<T> faster = node;

	    while (faster != null && faster.getNext() != null) {
	        temp = slow;
	        slow = slow.getNext();
	        faster = faster.getNext().getNext();
	    }

	    temp.setNext(null);

	    SingleLinkedListNode<T> left = mergeSort(node);
	    SingleLinkedListNode<T> right = mergeSort(slow);

	    return mergeRecursive(left, right);
	}

	
	
	public SingleLinkedListNode<T> bubbleSort(SingleLinkedListNode<T> node) {
		
		SingleLinkedListNode<T> first = node;
		
		while(!first.isNIL()) {
			
			SingleLinkedListNode<T> second = node.getNext();
			while(!second.isNIL()) {
				if(first.getData().compareTo(second.getData()) <= 0) {
					T tmp = first.getData();
					first.setData(second.getData());
					second.setData(tmp);
					
				}
				second = second.getNext();
			}
			
			first = first.getNext();
		}
		
		return node;
	}

	
	
	
	public SingleLinkedListNode<T> reverseRecursive(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> result = new SingleLinkedListNode<T>();
		if(node.isNIL() || node.getNext().isNIL()) {
			result = node;
			
		} else {
			SingleLinkedListNode<T> temp = reverseRecursive(node.getNext());
			node.getNext().setNext(node);
			node.setNext(new SingleLinkedListNode<T>());
			result =  temp;
		}
		
		return result;
	}
	
	
	public SingleLinkedListNode<T> reverseIterative(SingleLinkedListNode<T> node) {
		if(!node.isNIL()) {
			
			SingleLinkedListNode<T> current = node;
			SingleLinkedListNode<T> prev = new SingleLinkedListNode<T>();
			SingleLinkedListNode<T> next = new SingleLinkedListNode<T>();
			
			while(!current.isNIL()) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			return prev;
		}
		
		return null;
	}
	
	
	
	
	public boolean palindromo(SingleLinkedListNode<T> node) {
		
		SingleLinkedListNode<T> mid = middle(node);
		SingleLinkedListNode<T> reverseHead = reverseRecursive(mid);
		SingleLinkedListNode<T> reReverseHead = reverseHead;
		
		
		while(!node.isNIL() && !reverseHead.isNIL()) {
			if(!node.getData().equals(reReverseHead.getData())) {
				break;
			}
			
			node = node.getNext();
			reverseHead = reverseHead.getNext();
		}
		
		reverseRecursive(reReverseHead);
		
		if(node.isNIL() && reverseHead.isNIL()) {
			return true;
		} 
		return false;
	}
	
	
	
	public void reOrder(SingleLinkedListNode<T> node) {
		
		if(node.isNIL() || node.getNext().isNIL()) {
			return;
		}
		
		SingleLinkedListNode<T> mid = middle(node);
		
		SingleLinkedListNode<T> reverse = reverseRecursive(mid);
		
		SingleLinkedListNode<T> head = node;
		
		while(!head.isNIL() && !reverse.isNIL()) {
			SingleLinkedListNode<T> temp = head.next;
			head.next = reverse;
			head = temp;
			
			temp = reverse.next;
			reverse.next = head;
			reverse = temp;
		}
		
		if(!head.isNIL()) {
			head.next = new SingleLinkedListNode<T>();
		}
		
	}
	
	
	public SingleLinkedListNode<T> rotate(SingleLinkedListNode<T> node, int k) {
		if(k <= 0 || node.isNIL() || node.getNext().isNIL()) {
			return node;
		}
		
		
		SingleLinkedListNode<T> last = node;
		int length = 1;
		
		while(!last.getNext().isNIL()) {
			last = last.getNext();
			length++;
		}
		
		
		last.next = node;
		int rot = k % length;
		int skip = length - rot;
		SingleLinkedListNode<T> newLast = node;
		
		for (int i = 0; i < skip - 1; i++) {
			newLast = newLast.next;
		}
		
		node = newLast.next;
		newLast.next = new SingleLinkedListNode<T>();
		
		return node;
	}
	
	
	
	
	
	
	public Node removeNthFromEnd(Node head, int n) {
	      Node fast = head;
	      Node slow = head;
	        
	      // if there is only one node in list, then we can only delete that
	      if(head.next==null) return null;
	        
	      //move fast ptr forward by n
	      for(int i=0;i<n;i++){
	          fast = fast.next;
	      }

	      // if fast becomes null, means we want to delete head
	      if(fast == null) return head.next;
	        
	      while(fast.next!=null){
	          fast = fast.next;
	          slow = slow.next;
	      }
	        
	      // break link from next
	      slow.next = slow.next.next;
	        
	      // return head
	      return head;
	}
	
	public getNodeFromEnd(Node head, int n){
	    Node fast = head;
	    Node slow = head;
	    
	//moving fast ahead by n, to make gap
	    for(int i=0;i<n;i++){
	         fast = fast.next; 
	    }

	// when the fast reaches end, slow will be the nth node from end
	    while(fast.next!=null){
	         fast = fast.next;
	         slow = slow.next;
	    }
	    return slow; 
	}

	// NOTE: in case n is more than length of list, handle that case according to
	// problem given
	
	
	
	
	
	
	
	
	
	



	@Override
	public String toString() {
		String list = "";
		
		SingleLinkedListNode<T> aux = this.getHead();
		
		while(!aux.isNIL()) {
			
			if(aux.getNext().isNIL()) {
				list += aux.getData();
			} else {
			list += aux.getData() + " -> ";
			}
			aux = aux.getNext();
		}
		
		return list;
		
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
