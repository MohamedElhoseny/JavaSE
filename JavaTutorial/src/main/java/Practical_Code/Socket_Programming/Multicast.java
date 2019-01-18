package Practical_Code.Socket_Programming;

/**
 * Created by Elhosany on 9/6/2016.
 */
public class Multicast
{
    //    Introduction
    /*
       _ The Other works the data is destinated to only One Target  => UniCast
       _ Multicast means that a sender application will sent data to multiple receivers
       _ Multicast allow sending packets from one host to many other hosts

       Notes :
         Packets are sent to a group having an address called MultiCast address and the host that interested to receive packet must Join the Group

      _ Multicast has to send packet to each of the interested host using TCP or UDP

       Notes:
         In Multicasting Only one packet is created specifying on it the address of multicast , this address not represent one host but represent a group of hosts
         The Packet is placed on to the network and then reach each host  which join the group and interested to receive packet

      _ Java provide MulticastSocket Class which provides all multicasting methods
      _ What's the Multicast addresses ?
        => is a single address which represent multiple network devices forming a group so it used to identify group of devices that can send packet to them
        => Multicast address belong to Class D in ipv4 categorie  range from 224.0.0.0 to 239.255.255.255
               * 224.0.0.0 - 224.0.0.255 for local network  ,   224.0.1.0-224.0.1.255  for internetwork
     */

     //  MulticastSocket Class
     /*
         => Note that DatagramSocket class allow exchange of packets between exactly two programs , multicastSocket class is a subclass of DatagramSocket Class
         => MulticastSocket Provide few additional function as joining group and leaving group also allow to specify TTL field in Datagram Header
            and when packet reach each router will decrement by 1 and if equal 0 it will be discard

          Note That :
           Receiver in multicast lazem ye start first before sender l2n awl lma sender ybd2 el packet httb3t le group 2le feh receiver be accepty w msh hyb3tha
           mn tane l2y host gded   zy belzbt beinsport

      */

     //Very Important Note :
      /*
        DatagramSocket can use for Sending Data be it unicast or multicast or broadcast    BUT   can not receive Data in multicast  (can be uni or broad cast)
         So :
            We will build Sender Class using Datagram  and receiver Class using MultiCastSocket Or we can Use MulticastSocket in both as it have all method of
            DatagramSocket Class as it's a subclass to it   (really using multicast with UDP)
       */

      //When can i used Multicasting
    /*
       if there are more than two host neeed to Connect or if you use server and want to send packets to all host or or or or or ..... more
     */
}
