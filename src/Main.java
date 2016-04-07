public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable = new HashTable();
		hashTable = DBReader.readDatabase();
		System.out.println("\n-> Here is the HashTable\n");
		System.out.println(hashTable);
		System.out.println("\n-> Here is the keySet() of the HashTable\n");
		System.out.println(hashTable.keySet());
				
		/* Here are some debug prints that I have checked my functionality of my linked list class.
		 * Firstly, I created a linked list instance and added some key value pairs into it.
		 * Then checked my methods findNode(String key), remove(String key) methods respectively.
		 */
		
		System.out.println("\n-> LinkedList Class Test:");

		LinkedList ll = new LinkedList();		
		ll.add("x", "y");
		ll.add("a", "y");
		ll.add("b", "y");
		ll.add("d", "y");

		System.out.println("\n-> Here is the LinkedList instance we created\n");
		System.out.println(ll);
		
		System.out.println("\n-> findNode(key) examples\n");
		System.out.println(ll.findNode("a"));
		System.out.println(ll.findNode("b"));

		
		System.out.println("\n-> remove(key) examples\n");
		ll.remove("a");
		ll.remove("b");

		System.out.println("\n-> Here is the LinkedList after the removal of keys a and b\n");
		System.out.println(ll);
		
		/* Here I write out the hashtable which is created in the beginning to the txt file outpu2.txt
		 * in an increasing order.
		 */
		
		DBReader.writeSortedHashTable();
		
		System.out.println("\n-> Here is the HashTable after the removal of key: StringKey1\n");

		/* Now, I tried to remove the element with the key 'StringKey1' and it removed it successfully.
		 * Then printed it out to check if it works. 
		 */
		hashTable.remove("StringKey1");
		System.out.println(hashTable);
		
		System.out.println("\n-> Here is the Key Set of the HashTable after the removal of key: StringKey1\n");
		System.out.println(hashTable.keySet());
		
		/* I also tried to use the method empty(), and it worked here. However, I commented out
		 * since I may need to use the hash table for some purposes later on.
		 */
		
//		hashTable.empty();
//		System.out.println(hashTable.keySet());
		
		/* Now, It's time to check the functionality of my iterable interface and its methods overriden in
		 * the corresponding classes, Linkedlist and HashTable respectively. The results can be followed in the
		 * console and it also works properly.
		 */
		
		System.out.println("\n-> MyIterable Class Test for LinkedList\n");
		
		while(ll.hasNext()){
			System.out.println(ll.current());
			ll.remove();
		}
		System.out.println("\n-> Every element in the linked list is removed via MyIterable Interface\n");
		System.out.println(ll);
	
		System.out.println("\n-> MyIterable Class Test for HashTable\n");
		while(hashTable.hasNext()){
			System.out.println(hashTable.current());
			hashTable.remove();
		}
		System.out.println("\n-> Every element in the HashTable is removed via MyIterable Interface\n");
		System.out.println(hashTable);
		System.out.println("\n-> Every element in keySet() is removed via MyIterable Interface\n");
		System.out.println(hashTable.keySet());
		
		
		}
}
