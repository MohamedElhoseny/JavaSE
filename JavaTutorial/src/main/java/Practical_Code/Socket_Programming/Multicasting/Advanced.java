package Practical_Code.Socket_Programming.Multicasting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * Created by Elhosany on 9/6/2016.
 */
public class Advanced
{
        //hna b2a 3wzen application bt3na yb2a receiver w sender fe nfs el w2t bdl lma yb2a feh server application lw7do
        //la hwa el application be te connect m3 b3d fe b3d
        String name;
        MulticastSocket socket;
        InetAddress addrs;
        int port = 6001;

        public Advanced(String name)
        {
            try
            {
                this.name = name;
                socket = new MulticastSocket(6001);
                addrs = InetAddress.getByName("224.0.0.1");
                new receiver();
                new sender();

            }catch (Exception e) {
            }

        }
        public static void main(String[] args)
        {
            System.out.println("Enter You Nickname To Join Chat group : ");
            String n = new Scanner(System.in).next();
            new Advanced(n);
        }

    private class receiver extends Thread
    {
        public  receiver()
        {
            System.out.println("Start Receiving Service ..");
            this.start();
        }
        public void run()
        {
            byte[] rdata = new byte[256];
            try
            {
                socket.joinGroup(addrs);
                DatagramPacket packet = new DatagramPacket(rdata,rdata.length);

                while (true)
                {
                    socket.receive(packet);  //hyfdl wa2f hna l8ayt lma ygelo packet
                    String rmsg = new String(rdata, 0, packet.getLength());
                    System.out.println(rmsg);
                }
            }catch (Exception e) {
            }

        }
    }

    private class sender extends Thread
    {
        byte[] sdata;
        BufferedReader in;  //for reading inputs
        DatagramPacket packet;

        public sender()
        {
            System.out.println("Start Sending Service ..");
            this.start();
        }
        public void run()
        {
            try {
                while (true)
                {
                    //write message
                    in = new BufferedReader(new InputStreamReader(System.in));
                    String msg = name+": "+in.readLine();

                    //creating packet including message
                    sdata = msg.getBytes();
                    packet = new DatagramPacket(sdata,sdata.length,addrs,port);
                    //send packet to all host connect with this group
                    socket.send(packet);
                }
            }catch (Exception e){
            }
        }
    }
}
