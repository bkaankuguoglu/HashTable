
public class Node {
	private String key;
	private String value;
	private Node prev;
	private Node next;
	
	/* My LinkedList data structure consists of nodes such that each node has a previous and a next node
	 * that points out the previous and the next node. (Doubly). And also each node holds a key and value
	 * String fields.
	 */
	
	public Node(Node prev, Node next, String key, String value) {
		this.prev = prev;
		this.next = next;
		this.key = key;
		this.value = value;
	}
	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}

	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node (key = " + key + ", value = " + value + ")";
	}

}
