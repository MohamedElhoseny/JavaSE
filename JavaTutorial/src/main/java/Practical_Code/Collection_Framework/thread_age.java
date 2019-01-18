package Practical_Code.Collection_Framework;

import java.util.Comparator;

public class thread_age implements Comparable<thread_age>
{
     private int age;
     private int id;
     
     public thread_age(int id,int age)
     {
    	 this.id= id;
    	 this.age=age;
     }
     public int getage()
     {
    	 return age;
     }

    @Override
    public int compareTo(thread_age o1) {
        if (this.age > o1.age)
            return 1;
        else if (this.age == o1.age)
            return 0;

        return -1;
    }
}
