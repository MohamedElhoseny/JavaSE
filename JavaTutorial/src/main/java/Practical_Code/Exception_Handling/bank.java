package Practical_Code.Exception_Handling;

public class bank
{
    private long balance = 3200;
    private static long MaximumAmount = 100000;

    public void withdraw(long amount)
                        throws InsufficientAmountException, ExcessiveAmountException
    {
            
            if(balance < amount)
            throw new InsufficientAmountException(amount);
            
            if(amount > MaximumAmount)
            throw new ExcessiveAmountException(amount);
    }


    public static void main(String[] args) 
    {
        bank customer = new bank();

        try {
			customer.withdraw(144000);
		} catch (InsufficientAmountException | ExcessiveAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}