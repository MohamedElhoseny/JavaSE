package Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedClient;

import Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedServer.Result;

import java.io.*;
import java.net.Socket;

public class AdvancedClient1
{
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        Socket ClientEnd = new Socket("localhost",6001);
        System.out.println("Connected to Localhost at Port 6001 Succeed !");
        
        //Send Job Class to Server and Obj
        System.out.println("Sending Job Structure to Server ..");   
        String ClassFile = AdvancedClient1.class.getResource("Job.java").toString();
        FileInputStream read_job = new FileInputStream(ClassFile);
        byte[] b = new byte[read_job.available()];
        read_job.read(b);
        
        ObjectOutputStream toServer = new ObjectOutputStream(ClientEnd.getOutputStream());
        toServer.writeObject(ClassFile);   //send class name
        toServer.writeObject(b);   //send data of class
        Job server_job = new Job();
        toServer.writeObject(server_job);  //send object for class
        
        //Get Result Class  from Server
        System.out.println("Getting Result from Server ..");
        ObjectInputStream fromServer = new ObjectInputStream(ClientEnd.getInputStream());
        ClassFile = (String) fromServer.readObject();   //result class name
        byte[] bb = (byte[]) fromServer.readObject();   //read result imp
           //Create it
        FileOutputStream create_result = new FileOutputStream(ClassFile);
        create_result.write(bb);

        System.out.println("Preparing Results ..");
        //Get Result Class object
        Result r = (Result) fromServer.readObject();

        //Now I Can Navigate and View The Result of Server Job
        System.out.println("Output of Server Job = "+r.Output());
        System.out.println("Server Completed its Job in = "+r.CompleteTime());
    }
}
