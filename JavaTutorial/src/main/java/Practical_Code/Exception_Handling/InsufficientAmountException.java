package Practical_Code.Exception_Handling;



public class InsufficientAmountException extends Exception
{
    InsufficientAmountException(long amount)
    {
        super("ExcessiveAmountException : amount is equal to "+amount);
    }
}
