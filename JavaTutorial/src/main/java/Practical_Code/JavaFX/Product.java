package Practical_Code.JavaFX;

/**
 * Created by Elhosany on 9/9/2016.
 */
public class Product
{
     String name;
     double price;
     int quantity;


    public Product(String n , double p , int q) {
        this.name=n;
        this.price=p;
        this.quantity=q;
    }
    public String getName()
    {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }


}
