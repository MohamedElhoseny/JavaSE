package Practical_Code.Collection_Framework;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>
{
    private String student_name;
    private int student_id;
    private int student_age;
    private int age;
    private static final String school_name = "Elmohamadia";
    
    /**
     *  Sort in ascending order
     *  --> can be in descending order return -1 when > and when < 
     */
	@Override
	public int compareTo(Student obj)
	{
		if (this.student_age > obj.student_age)
			return 1;
		else if (this.student_age == obj.student_age)
			return 0;

       return -1;
	}

    public Student(int id ,int age ,String name) 
    {
		this.student_id = id;
		this.student_age = age;
		this.student_name = name;            
	}  
    public int getid()
    {
    	return this.student_id;
    }
    public int getage()
    {
    	return this.student_age;
    }
    public void print(String name)
    {
    	System.out.println("hello from print : "+name);
    }
	public void setage(int age)
	{
		this.age = age;
	}
}
