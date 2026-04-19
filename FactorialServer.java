/* Write a client-server socket program that will return the factorial of that number. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client");

            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            int number = Integer.parseInt(in.readLine());

            // Calculate factorial
            long fact = 1;
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }

            out.println("Factorial of " + number + " is: " + fact);

            socket.close();
            server.close();

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}