public class Main {
    public static void main(String[] args)
    {
        try {
            BankAccount account1 = new BankAccount(1000);
            BankAccount account2 = new BankAccount(2000);

            account1.deposit(500);
            account2.deposit(1000);
            System.out.println("Account 1 (deposit): " + account1);
            System.out.println("Account 2 (deposit): " + account2);

            account1.withdraw(200);//-200 = Invalid amount. Please enter a positive number.
            account2.withdraw(500);
            System.out.println("Account 1 (withdraw): " + account1);
            System.out.println("Account 2 (withdraw): " + account2);

            account1.addInterest();
            account2.addInterest();

            System.out.println("Account 1 (interest rate): " + account1);
            System.out.println("Account 2 (interest rate): " + account2);

            System.out.println("Total balance: " + BankAccount.getTotalBalance());
        }
        catch (BankException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InvalidAmountException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
