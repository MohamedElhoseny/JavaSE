package Practical_Code.Socket_Programming.TCP_SOCKET;

import Practical_Code.Collection_Framework.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ElHosany on 8/28/2016.
 */
public class ServerDemo4
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ServerSocket serverSocket = new ServerSocket(6001);

        System.out.println("Starting Listening at port 6001");
        Socket ServerEnd = serverSocket.accept();

        System.out.println("Request accepted !");

        ObjectInputStream fromClient = new ObjectInputStream(ServerEnd.getInputStream());
        Student x = (Student) fromClient.readObject();
        System.out.println("Retrieving Some Data that received from Client");
        System.out.println("Student id = "+x.getid());
        System.out.println("Student age = "+x.getage());
       // System.out.println("Modifying Some Data before Sending to Client");
       // x.setage(17);      failed to modify the object as class file not found in Server (Next Tip !)

        ObjectOutputStream toServer = new ObjectOutputStream(ServerEnd.getOutputStream());
        toServer.writeObject(x);
        System.out.print("Data Sent back to Client !");

    }
}
