package Practical_Code.Socket_Programming.TCP_SOCKET;

import Practical_Code.Collection_Framework.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ElHosany on 8/28/2016.
 */
public class ClientDemo3
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Socket ClientEnd = new Socket("localhost",6001);
        System.out.print("Connected to Server Localhost !");

        Student y;
        System.out.println("Enter Student id , age , Name");
        int id = new Scanner(System.in).nextInt(), age = new Scanner(System.in).nextInt();
        String name = new Scanner(System.in).next();

        y =  new Student(id,age,name);

        ObjectOutputStream toServer = new ObjectOutputStream(ClientEnd.getOutputStream());
        toServer.writeObject(y);
        System.out.println("Object Send to Server !");

        ObjectInputStream fromServer = new ObjectInputStream(ClientEnd.getInputStream());
        y = (Student) fromServer.readObject();
        System.out.println("Object has reconstruct again and received from Server");

        System.out.println("Check age = "+y.getage());
    }
}
