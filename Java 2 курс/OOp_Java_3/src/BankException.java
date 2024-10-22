public class BankException extends Exception
{
    public BankException()
    {
        super("Insufficient funds on the account");
    }
}
