public class InvalidAmountException  extends Exception{
    public InvalidAmountException()
    {
        super("Invalid amount. Please enter a positive number.");
    }
}
