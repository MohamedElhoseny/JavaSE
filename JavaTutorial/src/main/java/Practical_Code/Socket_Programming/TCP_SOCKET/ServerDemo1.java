package Practical_Code.Socket_Programming.TCP_SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ElHosany on 8/27/2016.
 */
public class ServerDemo1
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(6001);

        System.out.println("Server Start Listening on Port 6001  ....");
        Socket ServerEnd = serverSocket.accept();   //Now i make it to accept only a request from Client


        BufferedReader fromClient = new BufferedReader(new InputStreamReader(ServerEnd.getInputStream()));
        System.out.println("Request accepted !");

        //need to calculate factorial and send to user
        int n = Integer.parseInt(fromClient.readLine());

        System.out.println("Client Send Us : "+n+" to Calculate it :");
        int fact = 1;
        for (int i=2 ; i <= n  ; i++)
        {
            fact = fact * i;
        }

        PrintWriter toClient = new PrintWriter(ServerEnd.getOutputStream() , true);
        System.out.println("Sending Result to Client");
        toClient.println(fact);


    }
}
