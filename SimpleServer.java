/* Code to start a server */

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is waiting...");

            Socket socket = server.accept(); // wait for client

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from server!");

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
