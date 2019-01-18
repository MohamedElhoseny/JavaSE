package Practical_Code.Exception_Handling;

public class ExcessiveAmountException extends Exception
{
    ExcessiveAmountException(long amount)
    {
        super("ExcessiveAmountException : amount is equal to "+amount);
    }
}
