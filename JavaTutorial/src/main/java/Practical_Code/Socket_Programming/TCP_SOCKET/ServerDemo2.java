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
public class ServerDemo2
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket SS = new ServerSocket(6001);

        /*This Make Server Accept only one Request*/
     //   System.out.println("Server Start Listening at Port 6001 !");
     //   Socket ServerEnd = SS.accept();



        //Run ClientDemo1 and ClientDemo2 and Send Request to Server here  (We Notes Second must wait the First One)

        while(true)
        {
            System.out.println("Server Start Listening at Port 6001 ..");
            Socket ServerEnd = SS.accept();      //this will stop flow of code until request send to server
            System.out.println("Request Accepted !");

            BufferedReader fromClient = new BufferedReader(new InputStreamReader(ServerEnd.getInputStream()));
            int n = Integer.parseInt(fromClient.readLine());
            int fact = 1;
            for (int i = 2; i <= n; i++)
            {
                fact *= i;
            }
            PrintWriter toClient = new PrintWriter(ServerEnd.getOutputStream(),true);
            toClient.println(fact);
            System.out.println("Result Send to Client !");
        }

    }
}
