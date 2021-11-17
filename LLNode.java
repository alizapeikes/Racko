package RackO;

public class LLNode<T> {
	private T data;
	private LLNode<T> next;
	
	/**
	 * Constructor 
	 * @param data Data to be stored in the Node.
	 */
	public LLNode(T data) {
		this.data = data;
		next = null;
	}
	
	/**
	 * Sets the data of the node.
	 * @param data Data to be stored in the node;
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Sets the next Node
	 * @param next The next node.
	 */
	public void setNext(LLNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Returns the data of the node.
	 * @return The data of the node.
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * Returns the data of the next node.
	 * @return The data of the next node.
	 */
	public LLNode<T> getNext(){
		return next;
	}
	
}
