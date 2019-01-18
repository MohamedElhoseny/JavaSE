package Practical_Code.Generic_Programming.complex;

import java.math.BigDecimal;

class Complex<T extends BigDecimal, R extends  BigDecimal>
{
    public T real;
    public R imaginary;

    Complex(T real, R imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex()
    {

    }

    void add(Complex<T, R> b)
    {
        this.real      = (T) real.add(b.real);
        this.imaginary = (R) imaginary.add(b.imaginary);
    }

    void subtract(Complex b)
    {
        this.real      = (T) real.subtract(b.real);
        this.imaginary = (R) imaginary.subtract(b.imaginary);
    }

    void multiply(Complex b)
    {
        this.real      = (T) real.multiply(b.real);
        this.imaginary = (R) imaginary.multiply(b.imaginary);
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder().append(real);

        if (imaginary.compareTo(new BigDecimal(0)) > 0)
            sb.append('+');

        return sb.append(imaginary).append('i').toString();
    }
}
