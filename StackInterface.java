package RackO;

public interface StackInterface<T> {
	
	public T top();
	
	public void push(T data);
	//you can return or not
	public void pop();
	
	public boolean isEmpty();
	
	//What does it mean to be full?
	//Debatable to have this or not
	public boolean isFull();
}
