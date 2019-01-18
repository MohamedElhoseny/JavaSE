package Practical_Code.Socket_Programming.TCP_SOCKET.AdvancedServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Advanced_Server_Handler
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(6001);
        System.out.println("Server Start Listening at port 6001 ...");

        while (true)
        {
            Socket ServerEnd = serverSocket.accept();   //listen
            System.out.println("Request Accepted !");
            new AdvancedServer2(ServerEnd);
        }

        /*   Problem when i Served a Client the Class Resultimp  implementation deleted !   */
        // nset  a2ra el 2wl el bytes bta3t resultimp class in Client from server
    }
}
