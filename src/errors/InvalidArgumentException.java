package errors;

public class InvalidArgumentException extends Exception{
    public InvalidArgumentException(String mensagem){
        super(mensagem);
    }
}
