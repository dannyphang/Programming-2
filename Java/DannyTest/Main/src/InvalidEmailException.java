

public class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super();
    }

    @Override
    public String toString(){
        return "Your email is not valid! Please try again.";
    }

}
