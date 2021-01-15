package nl.hp2consulting.sportenindebuurt.exceptions;

public class ConnectionException extends Exception {
    public ConnectionException(String exception){
        super(exception);
    }
    public ConnectionException(Exception exception) {
        super(exception);
    }
}
