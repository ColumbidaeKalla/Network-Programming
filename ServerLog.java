/* WAP to create a Server Socket with Connection Logs */

import java.net.ServerSocket;
import java.net.Socket;

public class ServerLog {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started on port 5000...");

            while (true) {
                Socket client = server.accept(); // wait for client

                System.out.println("New client connected!");
                System.out.println("Client IP   : " + client.getInetAddress());
                System.out.println("Client Port : " + client.getPort());

                client.close();
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}