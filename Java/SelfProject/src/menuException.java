public class menuException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public menuException(){
        super();
    }

    @Override
    public String toString(){
        return "Invalid Input!";
    }
}