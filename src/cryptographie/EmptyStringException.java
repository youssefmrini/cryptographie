package cryptographie;

public class EmptyStringException extends Exception{
	
	public EmptyStringException() { super(); }
	  public EmptyStringException(String message) { super(message); }
	  public EmptyStringException(String message, Throwable cause) { super(message, cause); }
	  public EmptyStringException(Throwable cause) { super(cause); }
}
