public class BankAccount
{
    private static double interestRate = 0.05;
    private static double totalBalance = 0;

    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
        totalBalance += initialBalance;
    }

    public void deposit(double amount) throws InvalidAmountException
    {
        if (amount > 0)
        {
            balance += amount;
            totalBalance += amount;
        } else {
            throw new InvalidAmountException();
        }
    }

    public void withdraw(double amount) throws BankException, InvalidAmountException
    {
        if (amount > 0)
        {
            if (balance >= amount)
            {
                balance -= amount;
                totalBalance -= amount;
            } else {
                throw new BankException();
            }
        } else {
            throw new InvalidAmountException();
        }
    }

    public double getBalance()
    {
        return balance;
    }

    public void addInterest()
    {
        double interest = balance * interestRate;
        balance += interest;
        totalBalance += interest;
    }

    public static double getTotalBalance()
    {
        return totalBalance;
    }

    @Override
    public String toString()
    {
        return  " balance = " + balance ;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0;
    }
}
