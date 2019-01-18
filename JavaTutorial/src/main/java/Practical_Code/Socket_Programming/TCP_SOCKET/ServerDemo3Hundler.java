package Practical_Code.Socket_Programming.TCP_SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ElHosany on 8/28/2016.
 */

public class ServerDemo3Hundler implements Runnable
{
    Socket ServerEnd;


    public  ServerDemo3Hundler(Socket channel)
    {
        this.ServerEnd = channel;
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                BufferedReader fromClient=new BufferedReader(new InputStreamReader(ServerEnd.getInputStream()));
                int n=Integer.parseInt(fromClient.readLine());

            /* Must Make a Miss Point that Make the Work with Client Stop at this point*/
                if (n == -1)
                {
                    ServerEnd.close();
                    break;
                }

                //work of this server (beg.)
                int fact=1;
                for (int i=2; i <= n; i++) {
                    fact*=i;
                }

                PrintWriter toClient=new PrintWriter(ServerEnd.getOutputStream(), true);
                toClient.println(fact);
                System.out.println("Result Send to Client !");

            } catch (IOException e) {

            }
        }
    }
}
