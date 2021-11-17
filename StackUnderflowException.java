package RackO;

public class StackUnderflowException extends RuntimeException {
	public StackUnderflowException(String message) {
		super(message);
	}
	
	public StackUnderflowException() {
		super("Stack Emtpy");
	}
}
