public class HashTable implements MyIterable{
	private static int size = 53;
	private int count;
	private LinkedList[] hashTable;
	private static int prime = 23;
	private LinkedList keySet;
	private int currentIndex;
	
	public HashTable() {
		count = 0;
		hashTable = new LinkedList[size];
		keySet = new LinkedList();
		currentIndex = 0;

	}
	public LinkedList[] getHashTable() {
		return hashTable;
	}
	public void setHashTable(LinkedList[] hashTable) {
		this.hashTable = hashTable;
	}
	public int capacity(){
		return size;
	}
	
	public int size(){
		return count;
	}

	/* Given hash function.
	 * 
	 */
	public static int hash(String key){
		int hash = 0; 
		int p=23;
	
		for (int i = 0; i < key.length(); i++)
			hash = (p * hash + key.charAt(i)) % size;
	
		return hash;
	}
	
	/* Puts the key value pair into the hashtable. If there is a key as the same as the key of the new element,
	 * then it adds after the last element in the chain. Otherwise, it creates a new linkedlist and adds the element
	 * into that list. (Seperate chaining)
	 * 
	 */
	
	public void put(String key, String value){
		int hash = hash(key);
		if(hashTable[hash] == null){
			LinkedList keyList = new LinkedList();
			keyList.addLast(key, value);
			hashTable[hash] = keyList;
		}
		else{
			hashTable[hash].addLast(key, value);
		}
		keySet.addLast(key, value);
		count++;

	}
	
	/* Removes the all elements in the hash table that have the key given as an input.
	 * 
	 */
	public void remove(String key){
		int hash = hash(key);
		for (int i = 0; i < size; i++) {
			
		if(hashTable[hash]!=null){
			Node removedNode = hashTable[hash].findNode(key);
			Node header = hashTable[hash].getHeader();
			Node trailer = hashTable[hash].getTrailer();
			if(removedNode!=null){
				if((removedNode.getPrev()==header)&&(removedNode.getNext()==trailer)){
					hashTable[hash] = null;
				}else{
				hashTable[hash].remove(key);
				keySet.remove(key);
			}}
			}
		}
	}
	/* Clears all the hash table and removes each separate chain one by one.
	 * 
	 */
	public void empty(){
		for (int i = 0; i < size; i++) {
			hashTable[i] = null;
			}
		keySet.removeAll();
	}
	/* If the hash table contains the key given as input it returns true, otherwise false.
	 * 
	 */
	public Boolean containsKey(String key){
		int hash = hash(key);
		if(hashTable[hash]!=null){
			return hashTable[hash].containsKey(key);
		}
		return false;
	}
	
	/* Returns the keySet of the hash table, which is a linked list of all elements in the hashmap.
	 * Since linkedlist is implemented to be an iterable class, the keySet is also iterable.
	 */
	public LinkedList keySet(){		
		return keySet;		
		
	}


	@Override
	public String toString() {
		String s = "";
		for (LinkedList linkedList : hashTable) {
			s += "\n" + linkedList;
		}
	return "HashTable [" + s + "]";
		
	}
	public static int getPrime() {
		return prime;
	}
	public static void setPrime(int prime) {
		HashTable.prime = prime;
	}
	
	/*
	 * (non-Javadoc)
	 * @see MyIterable#next()
	 * 
	 * The iterable class methods overriden by this class. 
	 */
	
	@Override
	public LinkedList next() {
		// TODO Auto-generated method stub
		setCurrentIndex(getCurrentIndex() + 1);
		return hashTable[getCurrentIndex()];
	}
	@Override
	public LinkedList current() {
		// TODO Auto-generated method stub
		return hashTable[getCurrentIndex()];
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(currentIndex<size-1){
			currentIndex++;
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		if(hashTable[currentIndex]!=null){
			while(hashTable[currentIndex].hasNext()){
				String key = hashTable[currentIndex].current().getKey();
				keySet.remove(key);
			}
		}
		hashTable[currentIndex] = null;	
	}
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
}
