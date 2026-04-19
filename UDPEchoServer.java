/* WAP to create a UDP client-socket echo program */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(5000);
            System.out.println("UDP Server started on port 5000...");

            byte[] buffer = new byte[1024];

            while (true) {
                // Receive packet
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(request);

                String message = new String(request.getData(), 0, request.getLength());
                System.out.println("Received: " + message);

                // Echo back to client
                DatagramPacket response = new DatagramPacket(
                        request.getData(),
                        request.getLength(),
                        request.getAddress(),
                        request.getPort());

                serverSocket.send(response);
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}