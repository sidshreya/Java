package lab2.exception;

@SuppressWarnings("serial")

public class TooManyRecordsException extends Exception{
	

	public TooManyRecordsException(String msg) {
		super(msg);
	}
		
	public TooManyRecordsException() {
		super();
	}	
	
	public void exceptionHandler() {
		System.out.println("Error: Records should not be more than 40");
	}
	
}