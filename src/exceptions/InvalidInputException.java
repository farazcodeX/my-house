package exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super();
    }
    public InvalidInputException(String massage) {
        super(massage);
    }
    
}
