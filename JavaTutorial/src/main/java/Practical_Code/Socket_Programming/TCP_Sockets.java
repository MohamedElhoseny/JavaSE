package Practical_Code.Socket_Programming;

import java.io.*;
import java.net.*;
import java.util.Enumeration;

/**
 * Created by ElHosany on 8/27/2016.
 */
public class TCP_Sockets
{
    public static void main(String[] args) throws IOException
    {
        //accept() make the server start listening to Client Requests
        //if we have more than one ip address on machine we can specify which ip used for server
        //When the Queue of requests is full , Connection request will rejected so we can set length of request's Queue
        //assigning port is called binding we can use bind() to set port , BindException fire when using reserved port
        //Sending and Recieving Data in Channel Using Streams in Socket Object  (Figure in your Mind!)


         /*  ServerSide  */
        ServerSocket serverSocket = new ServerSocket(6001);         //ports from 0 -> 65535
        Socket ServerEnd = serverSocket.accept();                   //Now server Start accept requests from Clients Side
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(ServerEnd.getInputStream()));     //read using readline()
        PrintWriter toClient = new PrintWriter(ServerEnd.getOutputStream());       //write data to client using println()



        /*  ClientSide   */
       Socket ClientEnd = new Socket("192.166.1.17", 6001);     //Create a Socket Channel with Server with ip = 192.168.1.17 and port = 6001
       BufferedReader fromServer = new BufferedReader(new InputStreamReader(ClientEnd.getInputStream()));
       PrintWriter toServer = new PrintWriter(ClientEnd.getOutputStream());



        //Now Figure 13.10 (ii) Created



        //IF I Have More than IP Address and Specify anyone to used for Server  eg: if i not Specify and ip address found in Server can access
        Enumeration<NetworkInterface> intf = NetworkInterface.getNetworkInterfaces();
        Enumeration<InetAddress> addrs = intf.nextElement().getInetAddresses();
        InetAddress Server_Address = addrs.nextElement();
        ServerSocket usingSpecific_IP = new ServerSocket(6001,100,Server_Address);   //Port , QueueLength , Address

        InetSocketAddress x = InetSocketAddress.createUnresolved("localhost",6001);    //or any ip mkan localhost
        usingSpecific_IP.bind(x);    //binding function used to set SocketAddresss we can not used it if u Construct ServerSocket with port


        //IF i need to Specify Client Side info
        Socket clientEnd = new Socket();
        clientEnd.bind(null);
        clientEnd.connect(new InetSocketAddress("192.168.1.17",6001));      //connect(SocketAddress obj)
        //Can Create SocketAddress object using InetSocketAddress which extends SocketAddress


    }
}
