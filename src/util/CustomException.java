package util;

public class CustomException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
