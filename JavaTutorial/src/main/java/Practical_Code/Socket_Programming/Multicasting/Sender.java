package Practical_Code.Socket_Programming.Multicasting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * Created by Elhosany on 9/6/2016.
 */
public class Sender
{
    //DatagramSocket can use in Sender Side as we dont need any functionality of multicast
    public static void main(String[] args) throws Exception
    {
         //Sender is as BeinSport System and Receiver is as people
        /* 2zn ana hna msh m7tag a3ml thread w yb2a kol client mn people yb2a leh thread la hwa wa7d thread w byb3t le kolo*/
        /* yb2a 2le by3ml join le group hwa el receiver 3shan kda lazem ast5dm fe receiver multicastSocket*/
        DatagramSocket socket = new DatagramSocket();  //as i will not receive any packet i will send only
        int i = 1;
        while (true)
        {
            String msg = "New Packet["+i+"] Sent !";
            byte[] sdata = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(sdata, sdata.length, InetAddress.getByName("224.0.0.1"), 6001);
            Thread.sleep(500);
            socket.send(packet); //Send packet to all hosts join the group
            i++;
        }
    }
}
