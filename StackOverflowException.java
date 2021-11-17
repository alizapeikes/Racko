package RackO;

public class StackOverflowException extends RuntimeException {
	public StackOverflowException(String message) {
		super(message);
	}
	
	public StackOverflowException() {
		super("Cannot be added to the Stack. Stack is Full");
	}
}
