package uaslp.objetos.exams;

public class MissingScoreException extends RuntimeException{
    public MissingScoreException(String message){
        super(message);
    }
}
