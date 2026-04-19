/* WAP a multithreaded client-server program for daytime service */

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Thread class to handle each client
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send current date and time
            out.println("Server Date & Time: " + new Date());

            socket.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}

public class DaytimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Daytime Server started on port 5000...");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress());

                // Create new thread for each client
                new ClientHandler(client).start();
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}