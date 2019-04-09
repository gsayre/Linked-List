/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;


public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  int numElts;
  Node insN;
  Node currentN;
  
  public LinkedListImpl(){
	  //this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
    numElts = 0;
  }
  
  //implement all methods in interface, and include the getRoot method we made for 
  //testing purposes. Feel free to implement private helper methods!
  public boolean insert(double elt, int index) {
	insN = new Node(elt);
	currentN = sentinel;
	
	//catching case where index is not reachable
	//decreases in size if the link cannot be inserted
	if (index > size() || index < 0) {
		return false;
	} 
	
	//case for inserting the first linked element
	if (size() == 0) {
			sentinel.next = insN;
			sentinel.prev = insN;
			insN.next = sentinel;
			insN.prev = sentinel;
			numElts++;
			return true;
		} else {
			
			//iterator to reach the index where you want to place the link at
			for (int i = 0; i < index; i++) {
				currentN = currentN.next;
			}
			
			//first takes the link before the one at the index and sets it's 
			//next field equal to the link being inserted 
			//then sets the link formerly at that index's previous field to the new link
			currentN.next.prev = insN;
			insN.next = currentN.next;
			currentN.next = insN;
			insN.prev = currentN;
			numElts++;
			return true;
			
		}
	  
  }
  
  public boolean remove (int index) {
	  currentN = sentinel;
	  
	//catching case where index is not reachable
	//does not remove anything so there is no end to the list
	//the code returns because there is no change
		if (index > size() || index < 0) {
			return false;	
		} 
		
		//case for deleting the only element in the list 
		if (size() == 1) {
				sentinel.next = sentinel;
				sentinel.prev = sentinel;
				numElts--;
				return true;
			} else {
				//iterator to reach the index where you want to place the link at
				for (int i = 0; i < index; i++) {
					currentN = currentN.next;
				}
				
				//first takes the link before the one at the index and sets it's 
				//next field equal to the link being inserted 
				//then sets the link formerly at that index's previous field to the new link
				currentN.next.next.prev = currentN;
				currentN.next = currentN.next.next;
				numElts--;
				return true;
				
			}
	  
  }
  
  public double get(int index) {
	  currentN = sentinel;
	  
	  //Returns Double.NaN for cases where trying to access indices outside of 
	  //the linked list
	  if (index > size() || index < 0) {
			return Double.NaN;	
		} 
	  
	  if (size() < 1) {
		  return Double.NaN;
	  }
	  
	//iterator to reach the index where you want to place the link at
		for (int i = 0; i < index; i++) {
			currentN = currentN.next;
		}
		
	  return currentN.next.getData();
  }
  
  public int size() {
	  return numElts;
  }
  
  public boolean isEmpty() {
	  if (size() == 0) {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public void clear() {
	  sentinel.next = sentinel;
	  sentinel.prev = sentinel;
	  numElts = 0;
  }
  
  public Node getRoot(){ 
//leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }
}