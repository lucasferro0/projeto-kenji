package errors;

public class ValidationException extends Exception{
    public ValidationException(String mensagem){
        super(mensagem);
    }   
}
