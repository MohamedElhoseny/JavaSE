package Practical_Code.Collection_Framework;

import java.util.Comparator;

public class CustomComparator implements Comparator<thread_age>
{
	@Override
	public int compare(thread_age o1, thread_age o2)
	{
		if (o1.getage() > o2.getage())
			return 1;
		else if (o1.getage() == o2.getage())
			return 0;

		return -1;
	}
}
	
	
	
	