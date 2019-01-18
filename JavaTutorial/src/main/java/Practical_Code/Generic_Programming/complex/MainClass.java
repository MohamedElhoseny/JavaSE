package Practical_Code.Generic_Programming.complex;

import java.math.BigDecimal;

class MainClass
{
    public static void main(String[] args)
    {
        Complex<BigDecimal, BigDecimal> c1 = new Complex<>(new BigDecimal(2.5), new BigDecimal(5.3));
        Complex<BigDecimal, BigDecimal> c2 = new Complex<>(new BigDecimal(3.5), new BigDecimal(1.3));

        System.out.println("Complex 1 : \n"+c1);
        System.out.println("Complex 2 : \n"+c2);

        c1.add(c2);
        System.out.println("After Adding complex 2 to complex 1 : \n" +c1);
        c1.subtract(c2);
        System.out.println("After Subtracting complex 2 to complex 1 : \n" +c1);
        c1.multiply(c2);
        System.out.println("After Multiplying complex 2 to complex 1 : \n" +c1);

    }
}
