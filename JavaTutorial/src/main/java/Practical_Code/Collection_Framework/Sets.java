package Practical_Code.Collection_Framework;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*     Set doesnt allow deplicated element as role
 *     Set interface provide => Hashset , LinkedHashset , TreeSet[implement Sorted Set]  so, treeset and treemap are sorted algorithm according to natural or element implement comparator interface
 *    Set have a primitive Methods : add, remove ,contain , size  from root class Collection
 *    the only way to traverse a Set using for each or iterator
 *      => iterator major methods : hasnext() , next() , remove()
 * 
 *    HashSet Note :
 *      This implementation is not thread-safe. So, explicit synchronization is needed if multiple 
		threads access a  HashSet  concurrently.
		Set syncSet = Collections.synchronizedSet(new HashSet());
		
		
		Most Collection  Must decleare there as Collections.Synchronized  to avoid problems while using multi-thread
 */


public class Sets 
{
  
    public static void main(String[] args)
    {
    	BitSet();
    }  
    
    public static void HashSet()
    {
        /**  HashSet   **/
    	
        // HashSet Constructors
		Set<Integer> empty = new HashSet<>();         //{}
		Set<Integer> even = new HashSet<>(Arrays.asList(0,2,4));  //{0,2,4}
		Set<Integer> cp = new HashSet<>(even);       //Copy set on set
		Set<Integer> sized = new HashSet<>(10);       //10 is the capacity
		Set<Integer> nullset = new HashSet<>(10,1);   //load factor 1
		Set<Integer> safe = Collections.synchronizedSet(new HashSet<>());  //safe thread if multi-thread work on this set

		//add
		even.add(6); //{0,2,4,6}
		even.add(8); //{0,2,4,6,8}
 		    	
		//remove
		even.remove(4);
 		    	
		//traverse
		for(Object x: even)
			System.out.println(x);

		//traverse using iterator
		Iterator<Integer> i = even.iterator();
		while(i.hasNext())
			System.out.println(i.next());

		//size
		int x = even.size();
		System.out.println(x);
 		    	
		boolean y = even.isEmpty();
		System.out.println(y);
 		    	
		//contain [check existance of element]
		if(even.contains(8))
			System.out.println("Found");

		//clear
		even.clear();

		//perform mathmatical operation as union , interaction , ....
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(2,3,4,5));

		//Union...
		Set<Integer> s3 = new HashSet<>(s1); //{1,2,3}    s2 {2,3,4,5}
		s3.addAll(s2);  //{1,2,3,4,5}        union obtained

		//intersection...
		s3.retainAll(s2);  //s3 {1,2,3,4,5}  s2 {2,3,4,5}   intersection =>  {2,3,4,5}

		//difference..
		s3.removeAll(s1);  //s3 {1,2,3,4,5}  s1 {1,2,3}  diff(found in s3 and not found in s1) => {4,5}
    }

    public static void LinkedHashSet()
    {
    	/** LinkedHashSet **/
    	
    	//same method and properties as HashSet
    	//extension to Hashset and used linked list and hash table
    	
    	Set s3 = new LinkedHashSet(8);
    	Set<Integer> x = Collections.synchronizedSet(new LinkedHashSet<>());   //safe
    	
    	//slightly slower performance than Hashset
    	//iteration time prop. to size of set not capacity as heapset   l2n dh linked  ay 7aga b3d kda linked t3rf 2ne el iteration feha a7sn
    }

    public static void TreeSet()
    {
    	//implement SortedSet which provide a total ordering on its element according to its natural
    	// time cost for its OOP operation is Log(n) such as add, ...
    	SortedSet<Integer> x = new TreeSet<>(Arrays.asList(2,3,5));

    	Object s1 = x.first();  //2
    	Object s2 = x.last();   //5
    	
    	x.add(1);  //now {1,2,3,5}
        x.add(4);  //now {1,2,3,4,5}
        
        //treeset method
        SortedSet t1 = x.headSet(3);      //y3ne el head hya el 3   {1,2}
        SortedSet t2 = x.tailSet(3);     // hya el tail   {3,4,5}
        SortedSet t3 = x.subSet(2, 5);  //from 2 to 5  {2,3,4}
    }

    public static void BitSet()
    {
        BitSet obj = new BitSet(5);   //same as sets
        for (int i = 0; i < 5; ++i)
        {
            obj.set(i);  //0,1,2,3,4
        }
        obj.clear(2);
        System.out.print(obj);  //0,1,3,4
    }
}

