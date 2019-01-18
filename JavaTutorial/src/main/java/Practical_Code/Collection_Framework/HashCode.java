package Practical_Code.Collection_Framework;

public class HashCode 
{
     public static void main(String[] args) 
     {
    	 String x = "omda";
    	 System.out.println(x.hashCode());

    	 String y = "omda";
		 System.out.println(y.hashCode());

    	 StringBuffer xx = new StringBuffer();
    	 xx.append("omda");
    	 System.out.println(xx.hashCode());
    	 
    	 Double xxx = 222.5;
    	 System.out.println(xxx.hashCode());
    	 
    	 Character xxxx = 'a';
    	 System.out.println(xxxx.hashCode());

     }
}
