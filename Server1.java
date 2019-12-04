
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apatt
 */
public class Server1 {

   public static void main(String[] args) throws SocketException,IOException{
       DatagramSocket serverSocket = new DatagramSocket(9876);
       Scanner sc = new Scanner(System.in);
       while(true){
           byte[] recievebuffer = new byte[1024];
           byte[] sendbuffer = new byte[1024];
           DatagramPacket recvdpkt = new DatagramPacket(recievebuffer, recievebuffer.length);// implementing UDP
           serverSocket.receive(recvdpkt);
           InetAddress IP = recvdpkt.getAddress();
           int portnu = recvdpkt.getPort();
           String clientdata = new String(recvdpkt.getData());
           System.out.println(IP);// prints out IP Address
           System.out.println(portnu);// prints out port number
            System.out.println("\nClient :"+ clientdata);// prints out clients data and response
            System.out.println("\nServer1 :");// prints out server
          String serverdata = sc.nextLine();
          sendbuffer = serverdata.getBytes();
          DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length,IP,portnu);// sends packet to server 
          serverSocket.send(sendPacket);
          if(serverdata.equalsIgnoreCase("bye"))
          {
              System.out.println("connection ended by server");
              break;
            
          }
                
          
       }
       serverSocket.close();
   } 
}

    

