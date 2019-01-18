package Practical_Code.Collection_Framework;

import java.util.*;

/*    Lists interface provides : ArrayList , LinkedList , vector
 *   ->  any list start with index zero and iterator interface provide listIterator
 *       It also provides a method to obtain an iterator that starts at a specified index in the list
 */


public class Lists 
{
    public static void main(String[] args)
    {
    	ArrayList_ReadOnly();
    }
    
    public static void ArrayList()
    {
    	/** create objects **/
		List<Integer> l3 = new ArrayList<>();
    	List<Integer> l2 = new ArrayList<>(Arrays.asList(2,3));
		List<Integer> l1 =  Collections.synchronizedList(new ArrayList<>());  //Thread-safe


		/** add , set **/
    	l2.add(3);
    	l3.add(3);
    	l2.add(1, 4);  // this will add element(4) in index 1 so the element in index 1 before will be in index 2,.. so add [not modified but replace]
    	l2.set(0, 6);  //modified element in specific index not replace any element from its index to another

    	/** get **/
    	System.out.println("item found in index 1 = "+ l2.get(1));

    	/** Size and empty **/
    	System.out.println("size of l2 = "+l2.size());
    	if (!l2.isEmpty()) {
			System.out.println("arraylist l2 is not empty");
		}

    	/** remove and clear **/
    	l3.remove(0);   //will delete element at index 0
    	l2.remove(Integer.valueOf(6));  //will delete element 6 [it will search for it and delete]
    	l1.clear();   //clear all list
    	
    	/** traverse **/
    	   
    	    //1- normal iterator
		Iterator<Integer> i = l2.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
    	 	      		    
		/* ListIterator addition :
    	  * this provide bidirectional traverse also listIterator has a cursor which is positioned
    	  * between elements , element before and after cursor returned by two method : next() , previous()
    	 */
    	    
		//2- listIteration
		ListIterator<Integer> ii = l2.listIterator();
		System.out.println("ListIterator iterator :");
		while (ii.hasNext()) {
			System.out.println(ii.next());
		}

		//now cursor at the end of list  [play with cursor]
		System.out.println("cursor now : "+ ii.previous());  //3
		if (ii.hasPrevious()){
			System.out.println("cursor now : "+ ii.previous());  //3
			System.out.println("cursor now : "+ ii.previous());  //4
		}
    }

    public static void ArrayList_ReadOnly()
	{
		List<String> fruitList = new ArrayList<>();

		fruitList.add("Mango");
		fruitList.add("Banana");
		fruitList.add("Apple");
		fruitList.add("Strawberry");
		fruitList.add("Pineapple");

		List<String> unmodifiableList = Collections.unmodifiableList(fruitList);
		//unmodifiableList.add("INDIA");      add,set,remove Not_Allowed


		/** Converting Arraylist to Array and vise-versa */

		//Arraylist -> Array
		String[] fruitArray = fruitList.toArray(new String[fruitList.size()]);
		System.out.println(fruitArray[2]);  //apple

		//Array -> Arraylist
		List<String> fruits = Arrays.asList(fruitArray);
		System.out.println(fruits.get(2));
	}
   
    public static void LinkedList()
    {
    	//this class implemented two interfaces List and Deque , and provides operation of this two
    	//internally use double linked list
    	List<Integer> l1 = Collections.synchronizedList(new LinkedList<>(Arrays.asList(1,2,3)));
    	
    	//according to list interface
    	l1.add(5);
    	l1.add(0, 20);
    	l1.set(1, 222);
        //l1.addAll(c)          method know at all structure to append collection as array or set or anything to your list
        //l1.addAll(index, c)   method to insert specific collection in specific index within list
    	
    	Iterator<Integer> i = l1.iterator();
    	while (i.hasNext()) {		
			System.out.println(i.next());
		}
    }

    // When to use ArrayList and LinkedList ??
}
