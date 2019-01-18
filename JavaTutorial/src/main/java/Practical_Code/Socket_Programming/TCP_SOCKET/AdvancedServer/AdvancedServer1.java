package Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedServer;

import Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedClient.Executable;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AdvancedServer1
{
    //main file of Server
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        ServerSocket serverSocket = new ServerSocket(6001);
        System.out.println("Server Start Listening at port 6001 ...");
        Socket ServerEnd = serverSocket.accept();   //listen
        System.out.println("Request Accepted !");

        System.out.println("Setting Job ..");
        //Get Job First
        ObjectInputStream fromClient = new ObjectInputStream(ServerEnd.getInputStream());
        String ClassFile = (String)fromClient.readObject();  //job class name
        byte[] b = (byte[])fromClient.readObject();   //job class implementation

        //Create Job Class in Server with its implementation
        FileOutputStream Job_File = new FileOutputStream(ClassFile);
        Job_File.write(b);

        Executable ex = (Executable)fromClient.readObject();    //read Job Object

        System.out.println("Start Working On Job ..");
        //Now Work With Job Submitted by Client
        double start_time = System.nanoTime();
        String output = ex.execute();
        double end_time = System.nanoTime();
        double complete_time = end_time - start_time;

        System.out.println("Preparing Result ..");
        //Preparing Result Object
        Resultimp result = new Resultimp(output,complete_time);

        //Sending Result Class and Object
        ObjectOutputStream toClient = new ObjectOutputStream(ServerEnd.getOutputStream());
        ClassFile = "D:\\FCIH\\Self-Study\\Java\\Projects\\JavaSE\\src\\Practical_Code\\Socket_Programming\\AdvancedServer\\Resultimp.java";
        FileInputStream result_file = new FileInputStream(ClassFile);  //to read Resultimp  implementation
        byte[] bb = new byte[result_file.available()];   //size of n.of byte in file

        toClient.writeObject(ClassFile); //Send class name
        toClient.writeObject(bb);  //Send Class Imp
        toClient.writeObject(result);  //Send Result Object to Client to use it to get Result Data

        System.out.println("Results are send to Client Succeed !!");
        ServerEnd.close();
        System.out.println("Client Served ! .. \n Connection Closed !");
    }
}
