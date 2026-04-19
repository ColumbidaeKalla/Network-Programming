/* WAP a multithreaded client-server program for daytime service using a thread pool of 50 */

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task to handle each client
class ClientTask implements Runnable {
    private Socket socket;

    public ClientTask(Socket socket) {
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

public class DaytimeServerPool {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Daytime Server (Thread Pool) started on port 5000...");

            // Create thread pool with 50 threads
            ExecutorService pool = Executors.newFixedThreadPool(50);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress());

                // Submit task to thread pool
                pool.execute(new ClientTask(client));
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}