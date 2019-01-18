package Practical_Code.Socket_Programming.TCP_SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ElHosany on 8/27/2016.
 */
public class ClientDemo1
{
    public static void main(String[] args) throws IOException
    {
        Socket ClientEnd = new Socket("localhost",6001);
        System.out.println("Client1 :Connected to Server Localhost ");

        System.out.println("Enter Number to Send to Server to Calculate Factorial to You : ");
        int x = new Scanner(System.in).nextInt();

        PrintWriter toServer = new PrintWriter(ClientEnd.getOutputStream() ,true);
        toServer.println(x);
        System.out.println(x+" Has Send to Server ! Waiting for Result..");

        BufferedReader fromServer = new BufferedReader(new InputStreamReader(ClientEnd.getInputStream()));
        System.out.println("Server Send us Result = "+fromServer.readLine());
    }
}
