
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
public class Client {
        public static void main(String[] args) throws SocketException,IOException {
        Scanner sc = new Scanner(System.in);
        InetAddress IP = InetAddress.getByName("localhost");
        DatagramSocket clientsocket = new DatagramSocket();
        while(true)
        {
            byte[] sendbuffer = new byte[1024];
            byte[] receivebuffer = new byte[1024];
            System.out.print("\nClient: ");
            String Clientdata = sc.nextLine();
            sendbuffer = Clientdata.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendbuffer, sendbuffer.length, IP, 9876); // send packets to the server
            clientsocket.send(sendPacket);
            if(Clientdata.equalsIgnoreCase("bye"))
            {
                System.out.println("connection ended by client");
                break;
            }
            DatagramPacket receivePacket = new DatagramPacket(receivebuffer, receivebuffer.length);
            clientsocket.receive(receivePacket);
            String serverData = new String(receivePacket.getData());
            System.out.print("\nServer1: " + serverData);
        }
    }
}
