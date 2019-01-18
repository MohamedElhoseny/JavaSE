package Practical_Code.Socket_Programming.TCP_SOCKET;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ElHosany on 8/28/2016.
 */
public class ServerDemo3
{
      /* This is Perfect */
    public static void main(String[] args) throws IOException
    {
        /* The job of it only get request and make new hundler thread with this channel socket with client*/

        ServerSocket serverSocket = new ServerSocket(6001);
        System.out.println("Start Listening at Port 6001 ..");

        Socket ServerEnd;
        while (true)
        {
            ServerEnd = serverSocket.accept();
            System.out.println("Request Accepted !");
            new ServerDemo3Hundler(ServerEnd);
        }
    }
}
