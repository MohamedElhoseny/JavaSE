package Practical_Code.Collection_Framework;
import java.util.*;

public class Algorithms 
{

	public static void main(String[] args)
	{
		sorting();
	}
		
	public static void sorting()
	{
		// We have TreeMap and TreeSet which implement Sorted sets and maps  so this algorithms are sorted element
		// we dont have a sorted Lists  Whats we do if we need to sort lists  thats dont implement any sorted interface
		// using  Sort() Method in Collections Class [head] => sort element according to natural or  custom sorting (using comparator)
		// this method uses slightly mergeSort algorithm
		
		/** Sorting (natural) **/
		
		List<Integer> myList = Collections.synchronizedList(new ArrayList<>(Arrays.asList(2,4,3,5,1,3,4,0)));
		Collections.sort(myList);  //HAM : default sort for sort method => Ascending order
        System.out.println("Natural Sorting : \n"+myList);
		
        /** Sorting (Custom using Comparator Interface)  **/
		
		//This form takes a  Comparator  in addition to a  List

		thread_age t1 = new thread_age(1001, 17);
		thread_age t2 = new thread_age(1002, 18);
		thread_age t3 = new thread_age(1003, 12);
		thread_age t4 = new thread_age(1004, 22);

		List<thread_age> trace = new ArrayList<>();
		trace.add(t1);
		trace.add(t2);
		trace.add(t3);
		trace.add(t4);

		/** Predefined comparator */
		//Comparator<Integer> cmp = Collections.reverseOrder();    //descending order
		//myList.sort(cmp);
		
		/** defined comparator */
	    //trace.sort(new algo_work());

		/** using Comparable */
		Collections.sort(trace);
	   
	    for (thread_age t : trace)
		  System.out.println(t.getage());

	}

    public static void searching()
    {
    	//to search with binarysearch()  list must be sorted  , if not sorted the role get wrong result
    	List<Integer> list = new ArrayList<>(Arrays.asList(1,3,4,2,4,5,6));   //{1,2,3,4,4,5,6}
    	Collections.sort(list);

		//search for element = 3  : will return index or negative value if not found
    	int index = Collections.binarySearch(list, 3);
    	System.out.println(index);
    	
    	index = Collections.binarySearch(list, 7);
    	System.out.println(index);
    	
    	
    	//Finding Extreme (min , max) value
    	int min = Collections.min(list);
    	int max = Collections.max(list);
    	System.out.println("Max = "+max+" min = "+min);
    }

	public static void manipulate()
	{
		/*      Shuffling..
		 *   Shuffling is sometimes necessary such as generating test cases , data for games , etc ..
		 *   two form of Shuffling Default and another one take obj from Random to be specific explicity
		 */

		//Shuffling
		List<Object> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Collections.shuffle(l);
		System.out.println(l);

		List<Object> l2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Collections.shuffle(l2, new Random());
		System.out.println(l2);


		//reverse
		l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Collections.reverse(l);
		System.out.println(l);


		//swapping
		Collections.swap(l, 0, 5); //index 0 with index 5

		int z = l.size();
		for (int i = 0; i < z/2; i++) {
			Collections.swap(l, i, z-i-1);
		}
		System.out.println(l);


		//Copying
		l2 = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
		Collections.copy(l2, l);   //copy all of L into L2
		System.out.println(l2);

		//fill
		Collections.fill(l2, 1);
		System.out.println(l2);  //{1,1,1,1,1,}

		// Collections.FUNCTION ----------> (list,set,map,queue)
		// Arrays.FUNCTION      ---------->  Array

		/** Array **/
		int[] arr = {5,4,3,2,1};
		Arrays.fill(arr, 1);
		Arrays.fill(arr, 0, 1, 88);
		for (int i : arr)
			System.out.println(i);

		int array[] = {2,6,2,5,4,3};
		Arrays.sort(array);
		for (int i = 0; i < 5; ++i)
			System.out.print(array[i]);


		//adding
		Collections.addAll(l2, 2);     //add 2 to list
		System.out.println(l2);
		Collections.addAll(l2, 3,4,5,6,4);      //add all this element to list
		System.out.println(l2);

	}

}
