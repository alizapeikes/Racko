package RackO;

public class CardStack<T> implements StackInterface<T> {
	private T[] cards;
	private int top;
	
	public CardStack(int amount) {
		cards = (T[]) new Object[amount]; 
		top = -1;
	}
	
	//Indicating that the top is not pointing anywhere.
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == cards.length - 1;
	}
	
	public void push(T data) {
		if(!isFull()) {
			cards[++top] = data;
		}else {
			throw new StackOverflowException();
		}
	}
	
	public void pop() {
		if(!isEmpty()) {
			--top;
		}else {
			throw new StackUnderflowException();
		}
	}
	
	public T top() {
		if(!isEmpty()) {
			return cards[top];
		}
		return null;
	}
}
