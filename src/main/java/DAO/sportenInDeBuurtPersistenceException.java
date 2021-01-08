package dao;

public class sportenInDeBuurtPersistenceException extends Exception {
	public sportenInDeBuurtPersistenceException(Exception exception){
		super(exception);
	}
	public sportenInDeBuurtPersistenceException(String message) {
		super(message);
	}

	public sportenInDeBuurtPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
