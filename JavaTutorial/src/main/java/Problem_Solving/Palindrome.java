package Problem_Solving;

public class Palindrome
{
    public static boolean isPalindrome(String word)
    {
        int i = 0;
        int j = word.length() - 1;

        while (j > i)
        {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(int number)
    {
        int palindrome = number;
        int reverse = 0;

        //Reverse Integer Number
        while (palindrome != 0)
        {
            int reminder = palindrome % 10;
            reverse = reverse * 10 + reminder;
            palindrome = palindrome / 10;
        }

        return number == reverse;
    }

    public static boolean advancedPalindrome(int number)
    {
        String intstr = String.valueOf(number);
        return intstr.equals(new StringBuilder(intstr).reverse().toString());
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("HellolleH"));
        System.out.println(isPalindrome("HelloolleH"));

        System.out.println(isPalindrome(57357));
        System.out.println(isPalindrome(57375));


        System.out.println(advancedPalindrome(57375));
    }
}
