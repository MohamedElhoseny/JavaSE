package Practical_Code.Collection_Framework;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*      Queue..
    *    Queues Implementation can order elements in FIFO [Queue] , LIFO [Stack] , Priority OOP
    *    => These implementation generally dont accept null element
    * 
    *
    *              Methods throwing Exception(IDE will not alert)     Method return value
    *   Insert  |             add(e)                                       offer(e)
    *   Delete  |           remove()                                        poll()
    *   Inspect |           element()                                       peek()
    *   
    *   linkedList(queue,stack) and PriorityQueue  implement the Queue Interface
    */

public class Queues
{
     public static void main(String[] args)
     {
    	 Priority_queue();
     }
     
     public static void LinkedList_queue()
     {
    	 
    /**********************************  FIFO [queue] *********************************/
    	 Queue<Integer> empty = new LinkedList<>();
    	 Queue<Integer> notempty = new LinkedList<>(Arrays.asList(1,2,3));   //1 => front   3=>rear


    	 /** add , offer [element added at rear] **/
    	 try {
    		 notempty.add(4);  //1,2,3,4
    	 }
    	 catch(Exception e)	 {
    		 System.out.println("error while inserting element in queue");
    	 }
    	 
    	 notempty.offer(5); //1,2,3,4,5


    	 /**  remove , poll **/
    	 notempty.remove();    //2,3,4,5
    	 notempty.poll();      //3,4,5


    	 /**  Inspecting **/
    	 
    	 //same as remove but it check the element at head not remove it   _3_4_5_|   => 3
    	 int first = notempty.element();
    	 int First = notempty.peek();             
    	 
    	 if(first == First)
    		 System.out.println("item peek : "+first);

    	 
    	  /***********************  LIFO [stack] and Default Stack Class ********************/
    	    
    	 Queue<Integer> stack = Collections.asLifoQueue(new LinkedList<>());     
    	 
    	 stack.add(1);
    	 stack.add(5);
    	 stack.add(6);
    	 
    	 System.out.println("Stack Items :");
    	 for (Integer i : stack) {
			System.out.println(i);     //6,5,1   will print  that mean last in  print first and so on ..
		}
    	 
    	 int x = stack.remove();
    	 System.out.println("item removed from stack : "+x);
    	 
      	 System.out.println("Stack Items :");
    	 for (Integer i : stack) {
			System.out.println(i);     //6,5,1   will print  that mean last in  print first and so on ..
		}
    	 
		/*****  Using Stack class  ******/
    	 Stack<Integer> s = new Stack<>();
    	 s.push(5);
    	 s.push(2);
    	 s.push(1);    //  _1_2_5_|
    	 
    	 System.out.println("Default Stack");
    	 System.out.println(s);
    	 
    	  x = s.pop();
    	  System.out.println("pop element : "+x);
     }

     public static void Priority_queue()
     {
    	 /*
    	  *  In Priority Queue the least element always sits at the top[head]
    	  *  Element's Class that will restored in the queue should implement the interface Comparable
    	  *  to provide CompareTo() method and least element or greatest as your implementation will sit
    	  *  at the top[head]  , so head is always the least among all the elements
    	  *   
    	  *    VIP NOTE : Priority Queue dont know how element in heap or queue sorted
    	  *    his jop make the least one at the top to do ...
    	  */
    	 Student x1 = new Student(1001, 11, "ahmed");
    	 Student x2 = new Student(1002, 8, "mohamed");
    	 Student x3 = new Student(1003, 9, "omda");
    	 Student x4 = new Student(1004, 10, "boba");
    	 Student x5 = new Student(1005, 9, "omda2");
    	 
    	 Queue<Student> Student_Registered = new PriorityQueue<>();
    	 
    	 Student_Registered.add(x1);
    	 Student_Registered.add(x2);
    	 Student_Registered.add(x3);
    	 Student_Registered.add(x4);
    	 Student_Registered.add(x5);
    	 
         for (Student s : Student_Registered)
			System.out.println("Student id = "+s.getid()+" , his age = "+s.getage());

         /*
    	 *     Note that : PriorityQueue  does not specify how other elements are exactly stored in heap. 
    	 *                 It only ensures that head element is always the least element.
         */ 

    	 Student asigned = Student_Registered.remove();
    	 System.out.println("Student id that has been Assigned to School Succeded  =  "+asigned.getid());
    	 
    	 // Again Work to ensure
    	 System.out.println("List of Students again that will a Sign to School [age 's priority]: ");
         for (Student s : Student_Registered)
			System.out.println("Student id = "+s.getid()+" , his age = "+s.getage());


    	 //also can use element() and peek()
     } 

}
