public class LinkedList implements MyIterable{
	private Node header;
	private Node tailer;
	private int size;
	private Node currentNode;

	/* I designed linkedlist as a sequence of nodes such that
	 * each node is connected to its previous and its next node, like doubly linked list.
	 * Here comes the weird part, even though I claim that header and trailer nodes do not have 
	 * any value, ironically, they still have a key-value pair that shows that they are either header or trailer.
	 */
	
	public LinkedList() {
		header = new Node(null, tailer, "key", "val");
		tailer = new Node(header, null, "key", "val");
		currentNode = header;
		size = 0;
	}
	
	
	public Node getHeader() {
		return header;
	}
	public void setHeader(Node minusInf) {
		this.header = minusInf;
	}
	public Node getTrailer() {
		return tailer;
	}
	public void setTrailer(Node plusInf) {
		this.tailer = plusInf;
	}
	public Node getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}


	
	/* Adds the key value pair into the end of the linkedlist.
	 * 
	 */

	public void addLast(String key, String val){
		Node newNode = new Node(tailer.getPrev(), tailer, key, val);
		tailer.getPrev().setNext(newNode);
		tailer.setPrev(newNode);		
		size++;
	}
	

	/* Adds the key value pair into the beginning of the linkedlist.
	 * 
	 */
	public void addFirst(String key, String val){
		Node newNode = new Node(header, header.getNext(), key,val);
		header.setNext(newNode);		
		header.getNext().setPrev(newNode);
		size++;
	}
	
	/* Adds a key-value pair to the linked list. If the linked list has no elements, then
	 * it just uses the method addLast. Otherwise, it adds the new element in ascending order.
	 * 
	 */
	
	public void add(String key, String val){
		Node newNode = new Node(null, null, key,val);
		Node node = null;

		if(header.getNext()==tailer){
			addLast(key,val);
			
		}else if(header.getNext()==null){
			addLast(key,val);
		}
		else
		{
			node = header.getNext();
			while(node!=tailer){
				if(key.compareTo(node.getKey())<0){
					newNode.setNext(node);
					newNode.setPrev(node.getPrev());
					node.getPrev().setNext(newNode);
					node.setPrev(newNode);		
				}
				node = node.getNext();
				
			}	
			size++;

		}
		
	}
	
	/* Looks up the node according to the key given as String input. 
	 * 
	 */
	
	public Node findNode(String key){
		Node nextNode = header.getNext();
			while(nextNode!=tailer){
				if(key.equals(nextNode.getKey())){
					return nextNode;
				}
				nextNode = nextNode.getNext();
			}	
		return null;		
	}
	
	/* If the linked list contains the key given as input it returns true, otherwise false.
	 * 
	 */
	
	public Boolean containsKey(String key){
		Node n = findNode(key);		
		return (n!=null);		
}
	/* Removes the elements which has the key given as input.
	 * Simple deletion procedure.
	 */
	
	public void remove(String key){
		Node deletedNode = findNode(key);
		if(deletedNode!=null){
		deletedNode.getPrev().setNext(deletedNode.getNext());
		deletedNode.getNext().setPrev(deletedNode.getPrev());
		deletedNode.setNext(null);
		deletedNode.setPrev(null);
		}
	}


	@Override
	public String toString() {
		String s = "";
		Node node = header.getNext();
		Node trailer = tailer;
		while((node!=trailer)&&(node.getNext()!=null)){
			s += " -> " +  node ;
			node = node.getNext();
		}
		return "LinkedList [Header" + s + " -> Trailer]";

	}
	
	/* Removes all the elements in the linked list.
	 *
	 */
	public void removeAll(){
		header.getNext().setPrev(null);
		tailer.getPrev().setNext(null);
		header.setNext(tailer);
		tailer.setPrev(header);
	}
	

/*
 * (non-Javadoc)
 * @see MyIterable#next()
 * 
 * The iterable class methods overriden by this class. 
 */

	@Override
	public Node next() {
		// TODO Auto-generated method stub
		currentNode = currentNode.getNext();
		return currentNode;
	}


	@Override
	public Node current() {
		// TODO Auto-generated method stub
		return currentNode;
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if((currentNode.getNext()!=null)&&(currentNode.getNext()!=tailer)){
			currentNode = currentNode.getNext();
			return true;
		}else{
			return false;
		}
		
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public void remove() {
		// TODO Auto-generated method stub
		Node newNode = currentNode.getPrev();
		remove(currentNode.getKey());
		currentNode = newNode;
	}

}
