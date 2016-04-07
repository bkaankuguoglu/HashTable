/* MyIterable is the inteface in which I described the iterable methods for my data structures,
 * such as linkedlists and hashtables. Simple, next(), current(), hasNext(), and remove() are the 
 * methods which are overriden by any class implements this interface.
 * 
 */
public interface MyIterable<T> {
	
	public T next();
	
	public T current();
	
	public boolean hasNext();
	
	public void remove();
}
